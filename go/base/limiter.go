/**
 * Copyright (c) 2015-2022, FineX, All Rights Reserved.
 * @author Thomas.Zhuang
 * @date 2022/5/17
 */

package base

import (
	"time"
)

var DefaultLimiter = NewLimiter(1000, 5)

// Limiter 限流
type Limiter struct {
	seq chan int

	Bucket int64
	T      []int64
}

// NewLimiter 构造器
func NewLimiter(duration, limit int64) *Limiter {
	seq := make(chan int, 1)
	seq <- 0
	return &Limiter{
		seq: seq,

		Bucket: duration,
		T:      make([]int64, limit),
	}
}

// TryBeforeRun 限流阻塞
func (l *Limiter) TryBeforeRun() {
	idx := <-l.seq // idx & lock
	now := time.Now().UnixMilli()
	interval := now - l.T[idx]
	if interval < 0 {
		l.seq <- idx
		time.Sleep(time.Duration(l.Bucket-interval) * time.Millisecond)
		l.TryBeforeRun()
		return
	}

	if interval < l.Bucket {
		l.T[idx] += l.Bucket
		l.seq <- (idx + 1) % len(l.T)
		time.Sleep(time.Duration(l.Bucket-interval) * time.Millisecond)
	} else {
		l.T[idx] = now
		l.seq <- (idx + 1) % len(l.T)
	}
}
