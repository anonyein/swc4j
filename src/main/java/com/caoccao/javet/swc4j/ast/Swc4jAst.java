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

import com.caoccao.javet.swc4j.ast.interfaces.ISwc4jAst;
import com.caoccao.javet.swc4j.utils.SimpleList;

import java.util.List;
import java.util.Objects;

/**
 * The type Swc4j ast.
 *
 * @since 0.2.0
 */
public abstract class Swc4jAst implements ISwc4jAst {
    /**
     * The constant EMPTY_CHILDREN.
     *
     * @since 0.2.0
     */
    protected static final List<ISwc4jAst> EMPTY_CHILDREN = SimpleList.immutableOf();
    /**
     * The End position.
     *
     * @since 0.2.0
     */
    protected final int endPosition;
    /**
     * The Start position.
     *
     * @since 0.2.0
     */
    protected final int startPosition;
    /**
     * The Children.
     *
     * @since 0.2.0
     */
    protected List<ISwc4jAst> children;
    /**
     * The Parent.
     *
     * @since 0.2.0
     */
    protected ISwc4jAst parent;

    /**
     * Instantiates a new Swc4j ast.
     *
     * @param startPosition the start position
     * @param endPosition   the end position
     * @since 0.2.0
     */
    protected Swc4jAst(int startPosition, int endPosition) {
        children = EMPTY_CHILDREN;
        this.endPosition = endPosition;
        parent = null;
        this.startPosition = startPosition;
    }

    @Override
    public List<ISwc4jAst> getChildren() {
        return children;
    }

    @Override
    public int getEndPosition() {
        return endPosition;
    }

    @Override
    public ISwc4jAst getParent() {
        return parent;
    }

    @Override
    public int getStartPosition() {
        return startPosition;
    }

    @Override
    public void setParent(ISwc4jAst parent) {
        this.parent = parent;
    }

    /**
     * Update parent.
     *
     * @since 0.2.0
     */
    protected void updateParent() {
        getChildren().stream()
                .filter(Objects::nonNull)
                .forEach(node -> node.setParent(this));
    }
}
