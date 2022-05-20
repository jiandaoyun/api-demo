// Copyright 2022 huija
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

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
