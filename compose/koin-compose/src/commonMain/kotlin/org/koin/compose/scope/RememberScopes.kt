/*
 * Copyright 2017-2023 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
@file:OptIn(KoinInternalApi::class)

package org.koin.compose.scope

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import org.koin.compose.getKoin
import org.koin.compose.module.CompositionKoinScopeLoader
import org.koin.core.annotation.KoinInternalApi
import org.koin.core.scope.Scope

/**
 * Remember Koin Scope & run CompositionKoinScopeLoader to handle scope closure
 *
 * @author Arnaud Giuliani
 */
@Composable
inline fun rememberKoinScope(scope: Scope): Scope {
    val koin = getKoin()
    val wrapper = remember(scope) {
        CompositionKoinScopeLoader(scope, koin)
    }
    return wrapper.scope
}