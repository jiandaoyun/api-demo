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
				TryBeforeRun()
				t.Log(time.Now())
			}()
		}
		wg.Wait()
	})

	t.Run("slow speed", func(t *testing.T) {
		for i := 0; i < 3; i++ {
			time.Sleep(1 * time.Second)
			TryBeforeRun()
			t.Log(time.Now())
		}
	})
}
