/*
 * Copyright (c) 2024. caoccao.com Sam Cao
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.caoccao.javet.swc4j.ast.words;

import com.caoccao.javet.swc4j.ast.BaseSwc4jAstToken;
import com.caoccao.javet.swc4j.enums.Swc4jAstTokenType;

/**
 * The type Swc4j ast token true.
 *
 * @since 0.2.0
 */
public class Swc4jAstTokenTrue extends BaseSwc4jAstToken {
    /**
     * Instantiates a new Swc4j ast token true.
     *
     * @param startPosition  the start position
     * @param endPosition    the end position
     * @param lineBreakAhead the line break ahead
     * @since 0.2.0
     */
    public Swc4jAstTokenTrue(int startPosition, int endPosition, boolean lineBreakAhead) {
        super(startPosition, endPosition, lineBreakAhead);
    }

    @Override
    public String getText() {
        return Swc4jAstTokenType.True.getName();
    }

    @Override
    public Swc4jAstTokenType getType() {
        return Swc4jAstTokenType.True;
    }
}
