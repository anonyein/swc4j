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

package com.caoccao.javet.swc4j.ast.atom.tri;

import com.caoccao.javet.swc4j.ast.atom.BaseSwc4jAstTokenBiAtom;
import com.caoccao.javet.swc4j.enums.Swc4jAstTokenType;

/**
 * The type Swc4j ast token regex.
 *
 * @since 0.2.0
 */
public class Swc4jAstTokenRegex extends BaseSwc4jAstTokenBiAtom<String> {
    /**
     * The Flags.
     */
    protected final String flags;

    /**
     * Instantiates a new Swc4j ast token regex.
     *
     * @param text           the text
     * @param value          the value
     * @param flags          the flags
     * @param startPosition  the start position
     * @param endPosition    the end position
     * @param lineBreakAhead the line break ahead
     * @since 0.2.0
     */
    public Swc4jAstTokenRegex(
            String text, String value, String flags, int startPosition, int endPosition, boolean lineBreakAhead) {
        super(text, value, startPosition, endPosition, lineBreakAhead);
        this.flags = flags;
    }

    /**
     * Gets flags.
     *
     * @return the flags
     * @since 0.2.0
     */
    public String getFlags() {
        return flags;
    }

    @Override
    public Swc4jAstTokenType getType() {
        return Swc4jAstTokenType.Regex;
    }
}
