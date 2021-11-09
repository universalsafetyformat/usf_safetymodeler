/*******************************************************************************
* Copyright (c) 2021 ScopeSET Technology Deutschland GmbH (https://www.scopeset.de) and others.
* This program and the accompanying materials are made available under the
* terms of the Eclipse Public License 2.0 which is available at
* http://www.eclipse.org/legal/epl-2.0.
* 
* SPDX-License-Identifier: EPL-2.0
*******************************************************************************/
lexer grammar InternalUSFLanguageLexer;

@header {
package org.safe4i.usf.transformation.language.ide.contentassist.antlr.lexer;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ide.editor.contentassist.antlr.internal.Lexer;
}

PortDirectionINOUT : 'PortDirection.INOUT';

PortDirectionUNSET : 'PortDirection.UNSET';

PortDirectionOUT : 'PortDirection.OUT';

PortDirectionIN : 'PortDirection.IN';

PRECONDITION : 'PRECONDITION';

Transform : 'transform';

Boolean : 'boolean';

Integer : 'integer';

RETURN : 'RETURN';

String : 'String';

RULES : 'RULES';

False : 'false';

Float : 'float';

List : 'List';

Else : 'else';

Null : 'null';

True : 'true';

Void : 'void';

For : 'for';

Val : 'val';

Var : 'var';

ExclamationMarkEqualsSign : '!=';

AmpersandAmpersand : '&&';

LessThanSignEqualsSign : '<=';

EqualsSignEqualsSign : '==';

GreaterThanSignEqualsSign : '>=';

If : 'if';

In : 'in';

VerticalLineVerticalLine : '||';

ExclamationMark : '!';

LeftParenthesis : '(';

RightParenthesis : ')';

PlusSign : '+';

Comma : ',';

FullStop : '.';

Colon : ':';

LessThanSign : '<';

EqualsSign : '=';

GreaterThanSign : '>';

LeftCurlyBracket : '{';

RightCurlyBracket : '}';

fragment RULE_BEGIN : ;

fragment RULE_END : ;

RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : ('"' ('\\' .|~(('\\'|'"')))* '"'|'\'' ('\\' .|~(('\\'|'\'')))* '\'');

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;
