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

package com.caoccao.javet.swc4j.ast.enums;

import com.caoccao.javet.swc4j.jni2rust.Jni2RustClass;

@Jni2RustClass(ignore = true)
public enum Swc4jAstType {
    ArrayLit,
    ArrayPat,
    ArrowExpr,
    AssignExpr,
    AssignPat,
    AssignPatProp,
    AssignProp,
    AutoAccessor,
    AwaitExpr,
    BigInt,
    BindingIdent,
    BinExpr,
    BlockStmt,
    Bool,
    BreakStmt,
    CallExpr,
    CatchClause,
    Class,
    ClassDecl,
    ClassExpr,
    ClassMethod,
    ClassProp,
    ComputedPropName,
    CondExpr,
    Constructor,
    ContinueStmt,
    DebuggerStmt,
    Decorator,
    DoWhileStmt,
    EmptyStmt,
    ExportAll,
    ExportDecl,
    ExportDefaultDecl,
    ExportDefaultExpr,
    ExportDefaultSpecifier,
    ExportNamedSpecifier,
    ExportNamespaceSpecifier,
    ExprOrSpread,
    ExprStmt,
    FnDecl,
    FnExpr,
    ForInStmt,
    ForOfStmt,
    ForStmt,
    Function,
    GetterProp,
    Ident,
    IfStmt,
    Import,
    ImportDecl,
    ImportDefaultSpecifier,
    ImportNamedSpecifier,
    ImportStarAsSpecifier,
    Invalid,
    JsxAttr,
    JsxClosingElement,
    JsxClosingFragment,
    JsxElement,
    JsxEmptyExpr,
    JsxExprContainer,
    JsxFragment,
    JsxMemberExpr,
    JsxNamespacedName,
    JsxOpeningElement,
    JsxOpeningFragment,
    JsxSpreadChild,
    JsxText,
    KeyValuePatProp,
    KeyValueProp,
    LabeledStmt,
    MemberExpr,
    MetaPropExpr,
    MethodProp,
    Module,
    NamedExport,
    NewExpr,
    Null,
    Number,
    ObjectLit,
    ObjectPat,
    OptCall,
    OptChainExpr,
    Param,
    ParenExpr,
    PrivateMethod,
    PrivateName,
    PrivateProp,
    Regex,
    RestPat,
    ReturnStmt,
    Script,
    SeqExpr,
    SetterProp,
    SpreadElement,
    StaticBlock,
    Str,
    Super,
    SuperPropExpr,
    SwitchCase,
    SwitchStmt,
    TaggedTpl,
    ThisExpr,
    ThrowStmt,
    Tpl,
    TplElement,
    TryStmt,
    TsArrayType,
    TsAsExpr,
    TsCallSignatureDecl,
    TsConditionalType,
    TsConstAssertion,
    TsConstructorType,
    TsConstructSignatureDecl,
    TsEnumDecl,
    TsEnumMember,
    TsExportAssignment,
    TsExprWithTypeArgs,
    TsExternalModuleRef,
    TsFnType,
    TsGetterSignature,
    TsImportEqualsDecl,
    TsImportType,
    TsIndexedAccessType,
    TsIndexSignature,
    TsInferType,
    TsInstantiation,
    TsInterfaceBody,
    TsInterfaceDecl,
    TsIntersectionType,
    TsKeywordType,
    TsLitType,
    TsMappedType,
    TsMethodSignature,
    TsModuleBlock,
    TsModuleDecl,
    TsNamespaceDecl,
    TsNamespaceExportDecl,
    TsNonNullExpr,
    TsOptionalType,
    TsParamProp,
    TsParenthesizedType,
    TsPropertySignature,
    TsQualifiedName,
    TsRestType,
    TsSatisfiesExpr,
    TsSetterSignature,
    TsThisType,
    TsTplLitType,
    TsTupleElement,
    TsTupleType,
    TsTypeAliasDecl,
    TsTypeAnn,
    TsTypeAssertion,
    TsTypeLit,
    TsTypeOperator,
    TsTypeParam,
    TsTypeParamDecl,
    TsTypeParamInstantiation,
    TsTypePredicate,
    TsTypeQuery,
    TsTypeRef,
    TsUnionType,
    UnaryExpr,
    UpdateExpr,
    UsingDecl,
    VarDecl,
    VarDeclarator,
    WhileStmt,
    WithStmt,
    YieldExpr,
}
