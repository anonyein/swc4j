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

package com.caoccao.javet.swc4j.ast;

import com.caoccao.javet.swc4j.enums.Swc4jAstTokenType;
import com.caoccao.javet.swc4j.utils.JsonUtils;

/**
 * The type Base swc4j ast token.
 *
 * @since 0.2.0
 */
public abstract class BaseSwc4jAstToken {
    /**
     * The End position of the token.
     * It is zero-based.
     *
     * @since 0.2.0
     */
    protected int endPosition;
    /**
     * The Line break ahead.
     *
     * @since 0.2.0
     */
    protected boolean lineBreakAhead;
    /**
     * The Start position of the token.
     * It is zero-based.
     *
     * @since 0.2.0
     */
    protected int startPosition;

    /**
     * Instantiates a new Base swc4j ast token.
     *
     * @param startPosition  the start position
     * @param endPosition    the end position
     * @param lineBreakAhead the line break ahead
     * @since 0.2.0
     */
    public BaseSwc4jAstToken(int startPosition, int endPosition, boolean lineBreakAhead) {
        this.endPosition = endPosition;
        this.lineBreakAhead = lineBreakAhead;
        this.startPosition = startPosition;
    }

    /**
     * Gets end position.
     *
     * @return the end position
     * @since 0.2.0
     */
    public int getEndPosition() {
        return endPosition;
    }

    /**
     * Gets start position.
     *
     * @return the start position
     * @since 0.2.0
     */
    public int getStartPosition() {
        return startPosition;
    }

    /**
     * Gets text.
     *
     * @return the text
     * @since 0.2.0
     */
    public abstract String getText();

    /**
     * Gets type.
     *
     * @return the type
     * @since 0.2.0
     */
    public abstract Swc4jAstTokenType getType();

    /**
     * Is line break ahead.
     *
     * @return true : has a line break before the token, false : has no line break before the token
     * @since 0.2.0
     */
    public boolean isLineBreakAhead() {
        return lineBreakAhead;
    }

    /**
     * Sets end position.
     *
     * @param endPosition the end position
     * @since 0.2.0
     */
    public void setEndPosition(int endPosition) {
        this.endPosition = endPosition;
    }

    /**
     * Sets line break ahead.
     *
     * @param lineBreakAhead the line break ahead
     * @since 0.2.0
     */
    public void setLineBreakAhead(boolean lineBreakAhead) {
        this.lineBreakAhead = lineBreakAhead;
    }

    /**
     * Sets start position.
     *
     * @param startPosition the start position
     * @since 0.2.0
     */
    public void setStartPosition(int startPosition) {
        this.startPosition = startPosition;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{ \"lineBreakAhead\": ").append(lineBreakAhead);
        sb.append(", \"start\": ").append(startPosition);
        sb.append(", \"end\": ").append(endPosition);
        sb.append(", \"type\": \"").append(getType().name()).append("\"");
        sb.append(", \"text\": \"").append(JsonUtils.escape(getText())).append("\"");
        sb.append(" }");
        return sb.toString();
    }
}
