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

package com.caoccao.javet.swc4j.ast.atom.uni;

import com.caoccao.javet.swc4j.ast.atom.BaseSwc4jAstTokenUniAtom;
import com.caoccao.javet.swc4j.enums.Swc4jAstTokenType;

/**
 * The type Swc4j ast token shebang.
 *
 * @since 0.2.0
 */
public class Swc4jAstTokenShebang extends BaseSwc4jAstTokenUniAtom {
    /**
     * The Shebang.
     */
    protected final String shebang;

    /**
     * Instantiates a new Swc4j ast token shebang.
     *
     * @param text           the text
     * @param shebang        the shebang
     * @param startPosition  the start position
     * @param endPosition    the end position
     * @param lineBreakAhead the line break ahead
     * @since 0.2.0
     */
    public Swc4jAstTokenShebang(String text, String shebang, int startPosition, int endPosition, boolean lineBreakAhead) {
        super(text, startPosition, endPosition, lineBreakAhead);
        this.shebang = shebang;
    }

    /**
     * Gets shebang.
     *
     * @return the shebang
     * @since 0.2.0
     */
    public String getShebang() {
        return shebang;
    }

    @Override
    public Swc4jAstTokenType getType() {
        return Swc4jAstTokenType.Shebang;
    }
}
