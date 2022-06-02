/**
 * Copyright (c) 2015-2022, FineX, All Rights Reserved.
 * @author Thomas.Zhuang
 * @date 2022/5/17
 */

package base

import (
	"sync"
	"testing"
	"time"
)

func TestTryBeforeRun(t *testing.T) {
	t.Run("max speed", func(t *testing.T) {
		var wg sync.WaitGroup
		for i := 0; i < 15; i++ {
			wg.Add(1)
			go func() {
				defer wg.Done()
				DefaultLimiter.TryBeforeRun()
				t.Log(time.Now())
			}()
		}
		wg.Wait()
	})

	t.Run("slow speed", func(t *testing.T) {
		var wg sync.WaitGroup
		for i := 0; i < 3; i++ {
			time.Sleep(1 * time.Second)
			wg.Add(1)
			go func() {
				defer wg.Done()
				DefaultLimiter.TryBeforeRun()
				t.Log(time.Now())
			}()
		}
		wg.Wait()
	})
}
