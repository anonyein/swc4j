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

package com.caoccao.javet.swc4j.ast.expr;

import com.caoccao.javet.swc4j.ast.Swc4jAst;
import com.caoccao.javet.swc4j.ast.Swc4jAstSpan;
import com.caoccao.javet.swc4j.ast.enums.Swc4jAstType;
import com.caoccao.javet.swc4j.ast.interfaces.ISwc4jAstExpr;
import com.caoccao.javet.swc4j.ast.interfaces.ISwc4jAstJsxElementChild;
import com.caoccao.javet.swc4j.ast.miscs.Swc4jAstJsxClosingElement;
import com.caoccao.javet.swc4j.ast.miscs.Swc4jAstJsxOpeningElement;
import com.caoccao.javet.swc4j.jni2rust.Jni2RustClass;
import com.caoccao.javet.swc4j.utils.AssertionUtils;
import com.caoccao.javet.swc4j.utils.SimpleList;

import java.util.List;
import java.util.Optional;

@Jni2RustClass(name = "JSXElement")
public class Swc4jAstJsxElement
        extends Swc4jAst
        implements ISwc4jAstExpr {
    protected final List<ISwc4jAstJsxElementChild> children;
    protected final Optional<Swc4jAstJsxClosingElement> closing;
    protected final Swc4jAstJsxOpeningElement opening;

    public Swc4jAstJsxElement(
            Swc4jAstJsxOpeningElement opening,
            List<ISwc4jAstJsxElementChild> children,
            Swc4jAstJsxClosingElement closing,
            Swc4jAstSpan span) {
        super(span);
        this.children = SimpleList.immutableCopyOf(AssertionUtils.notNull(children, "Children"));
        this.closing = Optional.ofNullable(closing);
        this.opening = AssertionUtils.notNull(opening, "Opening");
        childNodes = SimpleList.copyOf(children);
        childNodes.add(opening);
        childNodes.add(closing);
        childNodes = SimpleList.immutable(childNodes);
    }

    public List<ISwc4jAstJsxElementChild> getChildren() {
        return children;
    }

    public Optional<Swc4jAstJsxClosingElement> getClosing() {
        return closing;
    }

    public Swc4jAstJsxOpeningElement getOpening() {
        return opening;
    }

    @Override
    public Swc4jAstType getType() {
        return Swc4jAstType.JsxElement;
    }
}
