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

package com.caoccao.javet.swc4j.ast.ts;

import com.caoccao.javet.swc4j.ast.Swc4jAst;
import com.caoccao.javet.swc4j.ast.enums.Swc4jAstType;
import com.caoccao.javet.swc4j.ast.interfaces.ISwc4jAstTsType;
import com.caoccao.javet.swc4j.utils.AssertionUtils;
import com.caoccao.javet.swc4j.utils.SimpleList;

import java.util.List;

public class Swc4jAstTsTypeParamInstantiation
        extends Swc4jAst {
    protected final List<ISwc4jAstTsType> params;

    public Swc4jAstTsTypeParamInstantiation(
            List<ISwc4jAstTsType> params,
            int startPosition,
            int endPosition) {
        super(startPosition, endPosition);
        this.params = SimpleList.immutableCopyOf(AssertionUtils.notNull(params, "Params"));
        children = SimpleList.immutableCopyOf(params);
        updateParent();
    }

    public List<ISwc4jAstTsType> getParams() {
        return params;
    }

    @Override
    public Swc4jAstType getType() {
        return Swc4jAstType.TsTypeParam;
    }
}
