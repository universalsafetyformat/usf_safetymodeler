package org.safe4i.usf.transformation.language.parser.antlr.lexer;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

/*******************************************************************************
* Copyright (c) 2021 ScopeSET Technology Deutschland GmbH (https://www.scopeset.de) and others.
* This program and the accompanying materials are made available under the
* terms of the Eclipse Public License 2.0 which is available at
* http://www.eclipse.org/legal/epl-2.0.
* 
* SPDX-License-Identifier: EPL-2.0
*******************************************************************************/
@SuppressWarnings("all")
public class InternalUSFLanguageLexer extends Lexer {
    public static final int Val=23;
    public static final int Null=19;
    public static final int RULE_BEGIN=45;
    public static final int Var=24;
    public static final int PRECONDITION=8;
    public static final int True=20;
    public static final int String=13;
    public static final int False=15;
    public static final int LessThanSign=40;
    public static final int LeftParenthesis=34;
    public static final int List=17;
    public static final int Boolean=10;
    public static final int Void=21;
    public static final int ExclamationMark=33;
    public static final int GreaterThanSign=42;
    public static final int RULE_ID=47;
    public static final int For=22;
    public static final int RightParenthesis=35;
    public static final int GreaterThanSignEqualsSign=29;
    public static final int Float=16;
    public static final int EqualsSignEqualsSign=28;
    public static final int PlusSign=36;
    public static final int RULE_INT=48;
    public static final int RULE_ML_COMMENT=50;
    public static final int PortDirectionIN=7;
    public static final int If=30;
    public static final int RULE_END=46;
    public static final int In=31;
    public static final int VerticalLineVerticalLine=32;
    public static final int RULE_STRING=49;
    public static final int RULE_SL_COMMENT=51;
    public static final int PortDirectionUNSET=5;
    public static final int RETURN=12;
    public static final int Comma=37;
    public static final int EqualsSign=41;
    public static final int AmpersandAmpersand=26;
    public static final int PortDirectionINOUT=4;
    public static final int LessThanSignEqualsSign=27;
    public static final int Colon=39;
    public static final int RightCurlyBracket=44;
    public static final int EOF=-1;
    public static final int FullStop=38;
    public static final int RULE_WS=52;
    public static final int LeftCurlyBracket=43;
    public static final int RULE_ANY_OTHER=53;
    public static final int Integer=11;
    public static final int Else=18;
    public static final int ExclamationMarkEqualsSign=25;
    public static final int Transform=9;
    public static final int RULES=14;
    public static final int PortDirectionOUT=6;

    // delegates
    // delegators

    public InternalUSFLanguageLexer() {;} 
    public InternalUSFLanguageLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalUSFLanguageLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "InternalUSFLanguageLexer.g"; }

    // $ANTLR start "PortDirectionINOUT"
    public final void mPortDirectionINOUT() throws RecognitionException {
        try {
            int _type = PortDirectionINOUT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalUSFLanguageLexer.g:19:20: ( 'PortDirection.INOUT' )
            // InternalUSFLanguageLexer.g:19:22: 'PortDirection.INOUT'
            {
            match("PortDirection.INOUT"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PortDirectionINOUT"

    // $ANTLR start "PortDirectionUNSET"
    public final void mPortDirectionUNSET() throws RecognitionException {
        try {
            int _type = PortDirectionUNSET;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalUSFLanguageLexer.g:21:20: ( 'PortDirection.UNSET' )
            // InternalUSFLanguageLexer.g:21:22: 'PortDirection.UNSET'
            {
            match("PortDirection.UNSET"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PortDirectionUNSET"

    // $ANTLR start "PortDirectionOUT"
    public final void mPortDirectionOUT() throws RecognitionException {
        try {
            int _type = PortDirectionOUT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalUSFLanguageLexer.g:23:18: ( 'PortDirection.OUT' )
            // InternalUSFLanguageLexer.g:23:20: 'PortDirection.OUT'
            {
            match("PortDirection.OUT"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PortDirectionOUT"

    // $ANTLR start "PortDirectionIN"
    public final void mPortDirectionIN() throws RecognitionException {
        try {
            int _type = PortDirectionIN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalUSFLanguageLexer.g:25:17: ( 'PortDirection.IN' )
            // InternalUSFLanguageLexer.g:25:19: 'PortDirection.IN'
            {
            match("PortDirection.IN"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PortDirectionIN"

    // $ANTLR start "PRECONDITION"
    public final void mPRECONDITION() throws RecognitionException {
        try {
            int _type = PRECONDITION;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalUSFLanguageLexer.g:27:14: ( 'PRECONDITION' )
            // InternalUSFLanguageLexer.g:27:16: 'PRECONDITION'
            {
            match("PRECONDITION"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PRECONDITION"

    // $ANTLR start "Transform"
    public final void mTransform() throws RecognitionException {
        try {
            int _type = Transform;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalUSFLanguageLexer.g:29:11: ( 'transform' )
            // InternalUSFLanguageLexer.g:29:13: 'transform'
            {
            match("transform"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Transform"

    // $ANTLR start "Boolean"
    public final void mBoolean() throws RecognitionException {
        try {
            int _type = Boolean;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalUSFLanguageLexer.g:31:9: ( 'boolean' )
            // InternalUSFLanguageLexer.g:31:11: 'boolean'
            {
            match("boolean"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Boolean"

    // $ANTLR start "Integer"
    public final void mInteger() throws RecognitionException {
        try {
            int _type = Integer;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalUSFLanguageLexer.g:33:9: ( 'integer' )
            // InternalUSFLanguageLexer.g:33:11: 'integer'
            {
            match("integer"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Integer"

    // $ANTLR start "RETURN"
    public final void mRETURN() throws RecognitionException {
        try {
            int _type = RETURN;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalUSFLanguageLexer.g:35:8: ( 'RETURN' )
            // InternalUSFLanguageLexer.g:35:10: 'RETURN'
            {
            match("RETURN"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RETURN"

    // $ANTLR start "String"
    public final void mString() throws RecognitionException {
        try {
            int _type = String;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalUSFLanguageLexer.g:37:8: ( 'String' )
            // InternalUSFLanguageLexer.g:37:10: 'String'
            {
            match("String"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "String"

    // $ANTLR start "RULES"
    public final void mRULES() throws RecognitionException {
        try {
            int _type = RULES;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalUSFLanguageLexer.g:39:7: ( 'RULES' )
            // InternalUSFLanguageLexer.g:39:9: 'RULES'
            {
            match("RULES"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULES"

    // $ANTLR start "False"
    public final void mFalse() throws RecognitionException {
        try {
            int _type = False;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalUSFLanguageLexer.g:41:7: ( 'false' )
            // InternalUSFLanguageLexer.g:41:9: 'false'
            {
            match("false"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "False"

    // $ANTLR start "Float"
    public final void mFloat() throws RecognitionException {
        try {
            int _type = Float;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalUSFLanguageLexer.g:43:7: ( 'float' )
            // InternalUSFLanguageLexer.g:43:9: 'float'
            {
            match("float"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Float"

    // $ANTLR start "List"
    public final void mList() throws RecognitionException {
        try {
            int _type = List;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalUSFLanguageLexer.g:45:6: ( 'List' )
            // InternalUSFLanguageLexer.g:45:8: 'List'
            {
            match("List"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "List"

    // $ANTLR start "Else"
    public final void mElse() throws RecognitionException {
        try {
            int _type = Else;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalUSFLanguageLexer.g:47:6: ( 'else' )
            // InternalUSFLanguageLexer.g:47:8: 'else'
            {
            match("else"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Else"

    // $ANTLR start "Null"
    public final void mNull() throws RecognitionException {
        try {
            int _type = Null;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalUSFLanguageLexer.g:49:6: ( 'null' )
            // InternalUSFLanguageLexer.g:49:8: 'null'
            {
            match("null"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Null"

    // $ANTLR start "True"
    public final void mTrue() throws RecognitionException {
        try {
            int _type = True;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalUSFLanguageLexer.g:51:6: ( 'true' )
            // InternalUSFLanguageLexer.g:51:8: 'true'
            {
            match("true"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "True"

    // $ANTLR start "Void"
    public final void mVoid() throws RecognitionException {
        try {
            int _type = Void;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalUSFLanguageLexer.g:53:6: ( 'void' )
            // InternalUSFLanguageLexer.g:53:8: 'void'
            {
            match("void"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Void"

    // $ANTLR start "For"
    public final void mFor() throws RecognitionException {
        try {
            int _type = For;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalUSFLanguageLexer.g:55:5: ( 'for' )
            // InternalUSFLanguageLexer.g:55:7: 'for'
            {
            match("for"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "For"

    // $ANTLR start "Val"
    public final void mVal() throws RecognitionException {
        try {
            int _type = Val;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalUSFLanguageLexer.g:57:5: ( 'val' )
            // InternalUSFLanguageLexer.g:57:7: 'val'
            {
            match("val"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Val"

    // $ANTLR start "Var"
    public final void mVar() throws RecognitionException {
        try {
            int _type = Var;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalUSFLanguageLexer.g:59:5: ( 'var' )
            // InternalUSFLanguageLexer.g:59:7: 'var'
            {
            match("var"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Var"

    // $ANTLR start "ExclamationMarkEqualsSign"
    public final void mExclamationMarkEqualsSign() throws RecognitionException {
        try {
            int _type = ExclamationMarkEqualsSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalUSFLanguageLexer.g:61:27: ( '!=' )
            // InternalUSFLanguageLexer.g:61:29: '!='
            {
            match("!="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ExclamationMarkEqualsSign"

    // $ANTLR start "AmpersandAmpersand"
    public final void mAmpersandAmpersand() throws RecognitionException {
        try {
            int _type = AmpersandAmpersand;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalUSFLanguageLexer.g:63:20: ( '&&' )
            // InternalUSFLanguageLexer.g:63:22: '&&'
            {
            match("&&"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "AmpersandAmpersand"

    // $ANTLR start "LessThanSignEqualsSign"
    public final void mLessThanSignEqualsSign() throws RecognitionException {
        try {
            int _type = LessThanSignEqualsSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalUSFLanguageLexer.g:65:24: ( '<=' )
            // InternalUSFLanguageLexer.g:65:26: '<='
            {
            match("<="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LessThanSignEqualsSign"

    // $ANTLR start "EqualsSignEqualsSign"
    public final void mEqualsSignEqualsSign() throws RecognitionException {
        try {
            int _type = EqualsSignEqualsSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalUSFLanguageLexer.g:67:22: ( '==' )
            // InternalUSFLanguageLexer.g:67:24: '=='
            {
            match("=="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EqualsSignEqualsSign"

    // $ANTLR start "GreaterThanSignEqualsSign"
    public final void mGreaterThanSignEqualsSign() throws RecognitionException {
        try {
            int _type = GreaterThanSignEqualsSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalUSFLanguageLexer.g:69:27: ( '>=' )
            // InternalUSFLanguageLexer.g:69:29: '>='
            {
            match(">="); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GreaterThanSignEqualsSign"

    // $ANTLR start "If"
    public final void mIf() throws RecognitionException {
        try {
            int _type = If;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalUSFLanguageLexer.g:71:4: ( 'if' )
            // InternalUSFLanguageLexer.g:71:6: 'if'
            {
            match("if"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "If"

    // $ANTLR start "In"
    public final void mIn() throws RecognitionException {
        try {
            int _type = In;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalUSFLanguageLexer.g:73:4: ( 'in' )
            // InternalUSFLanguageLexer.g:73:6: 'in'
            {
            match("in"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "In"

    // $ANTLR start "VerticalLineVerticalLine"
    public final void mVerticalLineVerticalLine() throws RecognitionException {
        try {
            int _type = VerticalLineVerticalLine;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalUSFLanguageLexer.g:75:26: ( '||' )
            // InternalUSFLanguageLexer.g:75:28: '||'
            {
            match("||"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "VerticalLineVerticalLine"

    // $ANTLR start "ExclamationMark"
    public final void mExclamationMark() throws RecognitionException {
        try {
            int _type = ExclamationMark;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalUSFLanguageLexer.g:77:17: ( '!' )
            // InternalUSFLanguageLexer.g:77:19: '!'
            {
            match('!'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "ExclamationMark"

    // $ANTLR start "LeftParenthesis"
    public final void mLeftParenthesis() throws RecognitionException {
        try {
            int _type = LeftParenthesis;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalUSFLanguageLexer.g:79:17: ( '(' )
            // InternalUSFLanguageLexer.g:79:19: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LeftParenthesis"

    // $ANTLR start "RightParenthesis"
    public final void mRightParenthesis() throws RecognitionException {
        try {
            int _type = RightParenthesis;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalUSFLanguageLexer.g:81:18: ( ')' )
            // InternalUSFLanguageLexer.g:81:20: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RightParenthesis"

    // $ANTLR start "PlusSign"
    public final void mPlusSign() throws RecognitionException {
        try {
            int _type = PlusSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalUSFLanguageLexer.g:83:10: ( '+' )
            // InternalUSFLanguageLexer.g:83:12: '+'
            {
            match('+'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "PlusSign"

    // $ANTLR start "Comma"
    public final void mComma() throws RecognitionException {
        try {
            int _type = Comma;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalUSFLanguageLexer.g:85:7: ( ',' )
            // InternalUSFLanguageLexer.g:85:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Comma"

    // $ANTLR start "FullStop"
    public final void mFullStop() throws RecognitionException {
        try {
            int _type = FullStop;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalUSFLanguageLexer.g:87:10: ( '.' )
            // InternalUSFLanguageLexer.g:87:12: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "FullStop"

    // $ANTLR start "Colon"
    public final void mColon() throws RecognitionException {
        try {
            int _type = Colon;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalUSFLanguageLexer.g:89:7: ( ':' )
            // InternalUSFLanguageLexer.g:89:9: ':'
            {
            match(':'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "Colon"

    // $ANTLR start "LessThanSign"
    public final void mLessThanSign() throws RecognitionException {
        try {
            int _type = LessThanSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalUSFLanguageLexer.g:91:14: ( '<' )
            // InternalUSFLanguageLexer.g:91:16: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LessThanSign"

    // $ANTLR start "EqualsSign"
    public final void mEqualsSign() throws RecognitionException {
        try {
            int _type = EqualsSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalUSFLanguageLexer.g:93:12: ( '=' )
            // InternalUSFLanguageLexer.g:93:14: '='
            {
            match('='); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "EqualsSign"

    // $ANTLR start "GreaterThanSign"
    public final void mGreaterThanSign() throws RecognitionException {
        try {
            int _type = GreaterThanSign;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalUSFLanguageLexer.g:95:17: ( '>' )
            // InternalUSFLanguageLexer.g:95:19: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "GreaterThanSign"

    // $ANTLR start "LeftCurlyBracket"
    public final void mLeftCurlyBracket() throws RecognitionException {
        try {
            int _type = LeftCurlyBracket;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalUSFLanguageLexer.g:97:18: ( '{' )
            // InternalUSFLanguageLexer.g:97:20: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "LeftCurlyBracket"

    // $ANTLR start "RightCurlyBracket"
    public final void mRightCurlyBracket() throws RecognitionException {
        try {
            int _type = RightCurlyBracket;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalUSFLanguageLexer.g:99:19: ( '}' )
            // InternalUSFLanguageLexer.g:99:21: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RightCurlyBracket"

    // $ANTLR start "RULE_BEGIN"
    public final void mRULE_BEGIN() throws RecognitionException {
        try {
            // InternalUSFLanguageLexer.g:101:21: ()
            // InternalUSFLanguageLexer.g:101:23: 
            {
            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_BEGIN"

    // $ANTLR start "RULE_END"
    public final void mRULE_END() throws RecognitionException {
        try {
            // InternalUSFLanguageLexer.g:103:19: ()
            // InternalUSFLanguageLexer.g:103:21: 
            {
            }

        }
        finally {
        }
    }
    // $ANTLR end "RULE_END"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalUSFLanguageLexer.g:105:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )* )
            // InternalUSFLanguageLexer.g:105:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            {
            // InternalUSFLanguageLexer.g:105:11: ( '^' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='^') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // InternalUSFLanguageLexer.g:105:11: '^'
                    {
                    match('^'); 

                    }
                    break;

            }

            if ( (input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // InternalUSFLanguageLexer.g:105:40: ( 'a' .. 'z' | 'A' .. 'Z' | '_' | '0' .. '9' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( ((LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||LA2_0=='_'||(LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalUSFLanguageLexer.g:
            	    {
            	    if ( (input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ID"

    // $ANTLR start "RULE_INT"
    public final void mRULE_INT() throws RecognitionException {
        try {
            int _type = RULE_INT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalUSFLanguageLexer.g:107:10: ( ( '0' .. '9' )+ )
            // InternalUSFLanguageLexer.g:107:12: ( '0' .. '9' )+
            {
            // InternalUSFLanguageLexer.g:107:12: ( '0' .. '9' )+
            int cnt3=0;
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( ((LA3_0>='0' && LA3_0<='9')) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalUSFLanguageLexer.g:107:13: '0' .. '9'
            	    {
            	    matchRange('0','9'); 

            	    }
            	    break;

            	default :
            	    if ( cnt3 >= 1 ) break loop3;
                        EarlyExitException eee =
                            new EarlyExitException(3, input);
                        throw eee;
                }
                cnt3++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_INT"

    // $ANTLR start "RULE_STRING"
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalUSFLanguageLexer.g:109:13: ( ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // InternalUSFLanguageLexer.g:109:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // InternalUSFLanguageLexer.g:109:15: ( '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0=='\"') ) {
                alt6=1;
            }
            else if ( (LA6_0=='\'') ) {
                alt6=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // InternalUSFLanguageLexer.g:109:16: '\"' ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // InternalUSFLanguageLexer.g:109:20: ( '\\\\' . | ~ ( ( '\\\\' | '\"' ) ) )*
                    loop4:
                    do {
                        int alt4=3;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0=='\\') ) {
                            alt4=1;
                        }
                        else if ( ((LA4_0>='\u0000' && LA4_0<='!')||(LA4_0>='#' && LA4_0<='[')||(LA4_0>=']' && LA4_0<='\uFFFF')) ) {
                            alt4=2;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // InternalUSFLanguageLexer.g:109:21: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalUSFLanguageLexer.g:109:28: ~ ( ( '\\\\' | '\"' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // InternalUSFLanguageLexer.g:109:48: '\\'' ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // InternalUSFLanguageLexer.g:109:53: ( '\\\\' . | ~ ( ( '\\\\' | '\\'' ) ) )*
                    loop5:
                    do {
                        int alt5=3;
                        int LA5_0 = input.LA(1);

                        if ( (LA5_0=='\\') ) {
                            alt5=1;
                        }
                        else if ( ((LA5_0>='\u0000' && LA5_0<='&')||(LA5_0>='(' && LA5_0<='[')||(LA5_0>=']' && LA5_0<='\uFFFF')) ) {
                            alt5=2;
                        }


                        switch (alt5) {
                    	case 1 :
                    	    // InternalUSFLanguageLexer.g:109:54: '\\\\' .
                    	    {
                    	    match('\\'); 
                    	    matchAny(); 

                    	    }
                    	    break;
                    	case 2 :
                    	    // InternalUSFLanguageLexer.g:109:61: ~ ( ( '\\\\' | '\\'' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop5;
                        }
                    } while (true);

                    match('\''); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_STRING"

    // $ANTLR start "RULE_ML_COMMENT"
    public final void mRULE_ML_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_ML_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalUSFLanguageLexer.g:111:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // InternalUSFLanguageLexer.g:111:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // InternalUSFLanguageLexer.g:111:24: ( options {greedy=false; } : . )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0=='*') ) {
                    int LA7_1 = input.LA(2);

                    if ( (LA7_1=='/') ) {
                        alt7=2;
                    }
                    else if ( ((LA7_1>='\u0000' && LA7_1<='.')||(LA7_1>='0' && LA7_1<='\uFFFF')) ) {
                        alt7=1;
                    }


                }
                else if ( ((LA7_0>='\u0000' && LA7_0<=')')||(LA7_0>='+' && LA7_0<='\uFFFF')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // InternalUSFLanguageLexer.g:111:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            match("*/"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ML_COMMENT"

    // $ANTLR start "RULE_SL_COMMENT"
    public final void mRULE_SL_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalUSFLanguageLexer.g:113:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // InternalUSFLanguageLexer.g:113:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // InternalUSFLanguageLexer.g:113:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>='\u0000' && LA8_0<='\t')||(LA8_0>='\u000B' && LA8_0<='\f')||(LA8_0>='\u000E' && LA8_0<='\uFFFF')) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // InternalUSFLanguageLexer.g:113:24: ~ ( ( '\\n' | '\\r' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            // InternalUSFLanguageLexer.g:113:40: ( ( '\\r' )? '\\n' )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0=='\n'||LA10_0=='\r') ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalUSFLanguageLexer.g:113:41: ( '\\r' )? '\\n'
                    {
                    // InternalUSFLanguageLexer.g:113:41: ( '\\r' )?
                    int alt9=2;
                    int LA9_0 = input.LA(1);

                    if ( (LA9_0=='\r') ) {
                        alt9=1;
                    }
                    switch (alt9) {
                        case 1 :
                            // InternalUSFLanguageLexer.g:113:41: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }

                    match('\n'); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SL_COMMENT"

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalUSFLanguageLexer.g:115:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // InternalUSFLanguageLexer.g:115:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // InternalUSFLanguageLexer.g:115:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt11=0;
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( ((LA11_0>='\t' && LA11_0<='\n')||LA11_0=='\r'||LA11_0==' ') ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // InternalUSFLanguageLexer.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt11 >= 1 ) break loop11;
                        EarlyExitException eee =
                            new EarlyExitException(11, input);
                        throw eee;
                }
                cnt11++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_WS"

    // $ANTLR start "RULE_ANY_OTHER"
    public final void mRULE_ANY_OTHER() throws RecognitionException {
        try {
            int _type = RULE_ANY_OTHER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // InternalUSFLanguageLexer.g:117:16: ( . )
            // InternalUSFLanguageLexer.g:117:18: .
            {
            matchAny(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ANY_OTHER"

    public void mTokens() throws RecognitionException {
        // InternalUSFLanguageLexer.g:1:8: ( PortDirectionINOUT | PortDirectionUNSET | PortDirectionOUT | PortDirectionIN | PRECONDITION | Transform | Boolean | Integer | RETURN | String | RULES | False | Float | List | Else | Null | True | Void | For | Val | Var | ExclamationMarkEqualsSign | AmpersandAmpersand | LessThanSignEqualsSign | EqualsSignEqualsSign | GreaterThanSignEqualsSign | If | In | VerticalLineVerticalLine | ExclamationMark | LeftParenthesis | RightParenthesis | PlusSign | Comma | FullStop | Colon | LessThanSign | EqualsSign | GreaterThanSign | LeftCurlyBracket | RightCurlyBracket | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt12=48;
        alt12 = dfa12.predict(input);
        switch (alt12) {
            case 1 :
                // InternalUSFLanguageLexer.g:1:10: PortDirectionINOUT
                {
                mPortDirectionINOUT(); 

                }
                break;
            case 2 :
                // InternalUSFLanguageLexer.g:1:29: PortDirectionUNSET
                {
                mPortDirectionUNSET(); 

                }
                break;
            case 3 :
                // InternalUSFLanguageLexer.g:1:48: PortDirectionOUT
                {
                mPortDirectionOUT(); 

                }
                break;
            case 4 :
                // InternalUSFLanguageLexer.g:1:65: PortDirectionIN
                {
                mPortDirectionIN(); 

                }
                break;
            case 5 :
                // InternalUSFLanguageLexer.g:1:81: PRECONDITION
                {
                mPRECONDITION(); 

                }
                break;
            case 6 :
                // InternalUSFLanguageLexer.g:1:94: Transform
                {
                mTransform(); 

                }
                break;
            case 7 :
                // InternalUSFLanguageLexer.g:1:104: Boolean
                {
                mBoolean(); 

                }
                break;
            case 8 :
                // InternalUSFLanguageLexer.g:1:112: Integer
                {
                mInteger(); 

                }
                break;
            case 9 :
                // InternalUSFLanguageLexer.g:1:120: RETURN
                {
                mRETURN(); 

                }
                break;
            case 10 :
                // InternalUSFLanguageLexer.g:1:127: String
                {
                mString(); 

                }
                break;
            case 11 :
                // InternalUSFLanguageLexer.g:1:134: RULES
                {
                mRULES(); 

                }
                break;
            case 12 :
                // InternalUSFLanguageLexer.g:1:140: False
                {
                mFalse(); 

                }
                break;
            case 13 :
                // InternalUSFLanguageLexer.g:1:146: Float
                {
                mFloat(); 

                }
                break;
            case 14 :
                // InternalUSFLanguageLexer.g:1:152: List
                {
                mList(); 

                }
                break;
            case 15 :
                // InternalUSFLanguageLexer.g:1:157: Else
                {
                mElse(); 

                }
                break;
            case 16 :
                // InternalUSFLanguageLexer.g:1:162: Null
                {
                mNull(); 

                }
                break;
            case 17 :
                // InternalUSFLanguageLexer.g:1:167: True
                {
                mTrue(); 

                }
                break;
            case 18 :
                // InternalUSFLanguageLexer.g:1:172: Void
                {
                mVoid(); 

                }
                break;
            case 19 :
                // InternalUSFLanguageLexer.g:1:177: For
                {
                mFor(); 

                }
                break;
            case 20 :
                // InternalUSFLanguageLexer.g:1:181: Val
                {
                mVal(); 

                }
                break;
            case 21 :
                // InternalUSFLanguageLexer.g:1:185: Var
                {
                mVar(); 

                }
                break;
            case 22 :
                // InternalUSFLanguageLexer.g:1:189: ExclamationMarkEqualsSign
                {
                mExclamationMarkEqualsSign(); 

                }
                break;
            case 23 :
                // InternalUSFLanguageLexer.g:1:215: AmpersandAmpersand
                {
                mAmpersandAmpersand(); 

                }
                break;
            case 24 :
                // InternalUSFLanguageLexer.g:1:234: LessThanSignEqualsSign
                {
                mLessThanSignEqualsSign(); 

                }
                break;
            case 25 :
                // InternalUSFLanguageLexer.g:1:257: EqualsSignEqualsSign
                {
                mEqualsSignEqualsSign(); 

                }
                break;
            case 26 :
                // InternalUSFLanguageLexer.g:1:278: GreaterThanSignEqualsSign
                {
                mGreaterThanSignEqualsSign(); 

                }
                break;
            case 27 :
                // InternalUSFLanguageLexer.g:1:304: If
                {
                mIf(); 

                }
                break;
            case 28 :
                // InternalUSFLanguageLexer.g:1:307: In
                {
                mIn(); 

                }
                break;
            case 29 :
                // InternalUSFLanguageLexer.g:1:310: VerticalLineVerticalLine
                {
                mVerticalLineVerticalLine(); 

                }
                break;
            case 30 :
                // InternalUSFLanguageLexer.g:1:335: ExclamationMark
                {
                mExclamationMark(); 

                }
                break;
            case 31 :
                // InternalUSFLanguageLexer.g:1:351: LeftParenthesis
                {
                mLeftParenthesis(); 

                }
                break;
            case 32 :
                // InternalUSFLanguageLexer.g:1:367: RightParenthesis
                {
                mRightParenthesis(); 

                }
                break;
            case 33 :
                // InternalUSFLanguageLexer.g:1:384: PlusSign
                {
                mPlusSign(); 

                }
                break;
            case 34 :
                // InternalUSFLanguageLexer.g:1:393: Comma
                {
                mComma(); 

                }
                break;
            case 35 :
                // InternalUSFLanguageLexer.g:1:399: FullStop
                {
                mFullStop(); 

                }
                break;
            case 36 :
                // InternalUSFLanguageLexer.g:1:408: Colon
                {
                mColon(); 

                }
                break;
            case 37 :
                // InternalUSFLanguageLexer.g:1:414: LessThanSign
                {
                mLessThanSign(); 

                }
                break;
            case 38 :
                // InternalUSFLanguageLexer.g:1:427: EqualsSign
                {
                mEqualsSign(); 

                }
                break;
            case 39 :
                // InternalUSFLanguageLexer.g:1:438: GreaterThanSign
                {
                mGreaterThanSign(); 

                }
                break;
            case 40 :
                // InternalUSFLanguageLexer.g:1:454: LeftCurlyBracket
                {
                mLeftCurlyBracket(); 

                }
                break;
            case 41 :
                // InternalUSFLanguageLexer.g:1:471: RightCurlyBracket
                {
                mRightCurlyBracket(); 

                }
                break;
            case 42 :
                // InternalUSFLanguageLexer.g:1:489: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 43 :
                // InternalUSFLanguageLexer.g:1:497: RULE_INT
                {
                mRULE_INT(); 

                }
                break;
            case 44 :
                // InternalUSFLanguageLexer.g:1:506: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 45 :
                // InternalUSFLanguageLexer.g:1:518: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 46 :
                // InternalUSFLanguageLexer.g:1:534: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 47 :
                // InternalUSFLanguageLexer.g:1:550: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 48 :
                // InternalUSFLanguageLexer.g:1:558: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA12 dfa12 = new DFA12(this);
    static final String DFA12_eotS =
        "\1\uffff\13\44\1\65\1\41\1\70\1\72\1\74\1\41\10\uffff\1\41\2\uffff\3\41\2\uffff\2\44\1\uffff\2\44\1\121\1\122\13\44\27\uffff\6\44\2\uffff\5\44\1\152\4\44\1\157\1\160\3\44\1\164\7\44\1\uffff\1\174\1\175\1\176\1\177\2\uffff\3\44\1\uffff\3\44\1\u0086\1\44\1\u0088\1\u0089\4\uffff\5\44\1\u008f\1\uffff\1\u0090\2\uffff\3\44\1\u0094\1\u0095\2\uffff\3\44\2\uffff\2\44\1\u009b\2\44\1\uffff\3\44\1\u00a1\1\44\5\uffff\1\u00a8\2\uffff";
    static final String DFA12_eofS =
        "\u00a9\uffff";
    static final String DFA12_minS =
        "\1\0\1\122\1\162\1\157\1\146\1\105\1\164\1\141\1\151\1\154\1\165\1\141\1\75\1\46\3\75\1\174\10\uffff\1\101\2\uffff\2\0\1\52\2\uffff\1\162\1\105\1\uffff\1\141\1\157\2\60\1\124\1\114\1\162\1\154\1\157\1\162\2\163\1\154\1\151\1\154\27\uffff\1\164\1\103\1\156\1\145\1\154\1\145\2\uffff\1\125\1\105\1\151\1\163\1\141\1\60\1\164\1\145\1\154\1\144\2\60\1\104\1\117\1\163\1\60\1\145\1\147\1\122\1\123\1\156\1\145\1\164\1\uffff\4\60\2\uffff\1\151\1\116\1\146\1\uffff\1\141\1\145\1\116\1\60\1\147\2\60\4\uffff\1\162\1\104\1\157\1\156\1\162\1\60\1\uffff\1\60\2\uffff\1\145\1\111\1\162\2\60\2\uffff\1\143\1\124\1\155\2\uffff\1\164\1\111\1\60\1\151\1\117\1\uffff\1\157\1\116\1\156\1\60\1\56\1\uffff\1\111\1\116\2\uffff\1\117\2\uffff";
    static final String DFA12_maxS =
        "\1\uffff\1\157\1\162\1\157\1\156\1\125\1\164\1\157\1\151\1\154\1\165\1\157\1\75\1\46\3\75\1\174\10\uffff\1\172\2\uffff\2\uffff\1\57\2\uffff\1\162\1\105\1\uffff\1\165\1\157\2\172\1\124\1\114\1\162\1\154\1\157\1\162\2\163\1\154\1\151\1\162\27\uffff\1\164\1\103\1\156\1\145\1\154\1\145\2\uffff\1\125\1\105\1\151\1\163\1\141\1\172\1\164\1\145\1\154\1\144\2\172\1\104\1\117\1\163\1\172\1\145\1\147\1\122\1\123\1\156\1\145\1\164\1\uffff\4\172\2\uffff\1\151\1\116\1\146\1\uffff\1\141\1\145\1\116\1\172\1\147\2\172\4\uffff\1\162\1\104\1\157\1\156\1\162\1\172\1\uffff\1\172\2\uffff\1\145\1\111\1\162\2\172\2\uffff\1\143\1\124\1\155\2\uffff\1\164\1\111\1\172\1\151\1\117\1\uffff\1\157\1\116\1\156\1\172\1\56\1\uffff\1\125\1\116\2\uffff\1\117\2\uffff";
    static final String DFA12_acceptS =
        "\22\uffff\1\37\1\40\1\41\1\42\1\43\1\44\1\50\1\51\1\uffff\1\52\1\53\3\uffff\1\57\1\60\2\uffff\1\52\17\uffff\1\26\1\36\1\27\1\30\1\45\1\31\1\46\1\32\1\47\1\35\1\37\1\40\1\41\1\42\1\43\1\44\1\50\1\51\1\53\1\54\1\55\1\56\1\57\6\uffff\1\34\1\33\27\uffff\1\23\4\uffff\1\24\1\25\3\uffff\1\21\7\uffff\1\16\1\17\1\20\1\22\6\uffff\1\13\1\uffff\1\14\1\15\5\uffff\1\11\1\12\3\uffff\1\7\1\10\5\uffff\1\6\5\uffff\1\5\2\uffff\1\2\1\3\1\uffff\1\1\1\4";
    static final String DFA12_specialS =
        "\1\2\34\uffff\1\1\1\0\u008a\uffff}>";
    static final String[] DFA12_transitionS = {
            "\11\41\2\40\2\41\1\40\22\41\1\40\1\14\1\35\3\41\1\15\1\36\1\22\1\23\1\41\1\24\1\25\1\41\1\26\1\37\12\34\1\27\1\41\1\16\1\17\1\20\2\41\13\33\1\10\3\33\1\1\1\33\1\5\1\6\7\33\3\41\1\32\1\33\1\41\1\33\1\3\2\33\1\11\1\7\2\33\1\4\4\33\1\12\5\33\1\2\1\33\1\13\4\33\1\30\1\21\1\31\uff82\41",
            "\1\43\34\uffff\1\42",
            "\1\45",
            "\1\46",
            "\1\50\7\uffff\1\47",
            "\1\51\17\uffff\1\52",
            "\1\53",
            "\1\54\12\uffff\1\55\2\uffff\1\56",
            "\1\57",
            "\1\60",
            "\1\61",
            "\1\63\15\uffff\1\62",
            "\1\64",
            "\1\66",
            "\1\67",
            "\1\71",
            "\1\73",
            "\1\75",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\32\44\4\uffff\1\44\1\uffff\32\44",
            "",
            "",
            "\0\107",
            "\0\107",
            "\1\110\4\uffff\1\111",
            "",
            "",
            "\1\113",
            "\1\114",
            "",
            "\1\115\23\uffff\1\116",
            "\1\117",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\23\44\1\120\6\44",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\1\123",
            "\1\124",
            "\1\125",
            "\1\126",
            "\1\127",
            "\1\130",
            "\1\131",
            "\1\132",
            "\1\133",
            "\1\134",
            "\1\135\5\uffff\1\136",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\137",
            "\1\140",
            "\1\141",
            "\1\142",
            "\1\143",
            "\1\144",
            "",
            "",
            "\1\145",
            "\1\146",
            "\1\147",
            "\1\150",
            "\1\151",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\1\153",
            "\1\154",
            "\1\155",
            "\1\156",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\1\161",
            "\1\162",
            "\1\163",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\1\165",
            "\1\166",
            "\1\167",
            "\1\170",
            "\1\171",
            "\1\172",
            "\1\173",
            "",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "",
            "",
            "\1\u0080",
            "\1\u0081",
            "\1\u0082",
            "",
            "\1\u0083",
            "\1\u0084",
            "\1\u0085",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\1\u0087",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "",
            "",
            "",
            "",
            "\1\u008a",
            "\1\u008b",
            "\1\u008c",
            "\1\u008d",
            "\1\u008e",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "",
            "",
            "\1\u0091",
            "\1\u0092",
            "\1\u0093",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "",
            "",
            "\1\u0096",
            "\1\u0097",
            "\1\u0098",
            "",
            "",
            "\1\u0099",
            "\1\u009a",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\1\u009c",
            "\1\u009d",
            "",
            "\1\u009e",
            "\1\u009f",
            "\1\u00a0",
            "\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "\1\u00a2",
            "",
            "\1\u00a3\5\uffff\1\u00a5\5\uffff\1\u00a4",
            "\1\u00a6",
            "",
            "",
            "\1\u00a7",
            "",
            ""
    };

    static final short[] DFA12_eot = DFA.unpackEncodedString(DFA12_eotS);
    static final short[] DFA12_eof = DFA.unpackEncodedString(DFA12_eofS);
    static final char[] DFA12_min = DFA.unpackEncodedStringToUnsignedChars(DFA12_minS);
    static final char[] DFA12_max = DFA.unpackEncodedStringToUnsignedChars(DFA12_maxS);
    static final short[] DFA12_accept = DFA.unpackEncodedString(DFA12_acceptS);
    static final short[] DFA12_special = DFA.unpackEncodedString(DFA12_specialS);
    static final short[][] DFA12_transition;

    static {
        int numStates = DFA12_transitionS.length;
        DFA12_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA12_transition[i] = DFA.unpackEncodedString(DFA12_transitionS[i]);
        }
    }

    class DFA12 extends DFA {

        public DFA12(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 12;
            this.eot = DFA12_eot;
            this.eof = DFA12_eof;
            this.min = DFA12_min;
            this.max = DFA12_max;
            this.accept = DFA12_accept;
            this.special = DFA12_special;
            this.transition = DFA12_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( PortDirectionINOUT | PortDirectionUNSET | PortDirectionOUT | PortDirectionIN | PRECONDITION | Transform | Boolean | Integer | RETURN | String | RULES | False | Float | List | Else | Null | True | Void | For | Val | Var | ExclamationMarkEqualsSign | AmpersandAmpersand | LessThanSignEqualsSign | EqualsSignEqualsSign | GreaterThanSignEqualsSign | If | In | VerticalLineVerticalLine | ExclamationMark | LeftParenthesis | RightParenthesis | PlusSign | Comma | FullStop | Colon | LessThanSign | EqualsSign | GreaterThanSign | LeftCurlyBracket | RightCurlyBracket | RULE_ID | RULE_INT | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA12_30 = input.LA(1);

                        s = -1;
                        if ( ((LA12_30>='\u0000' && LA12_30<='\uFFFF')) ) {s = 71;}

                        else s = 33;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA12_29 = input.LA(1);

                        s = -1;
                        if ( ((LA12_29>='\u0000' && LA12_29<='\uFFFF')) ) {s = 71;}

                        else s = 33;

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA12_0 = input.LA(1);

                        s = -1;
                        if ( (LA12_0=='P') ) {s = 1;}

                        else if ( (LA12_0=='t') ) {s = 2;}

                        else if ( (LA12_0=='b') ) {s = 3;}

                        else if ( (LA12_0=='i') ) {s = 4;}

                        else if ( (LA12_0=='R') ) {s = 5;}

                        else if ( (LA12_0=='S') ) {s = 6;}

                        else if ( (LA12_0=='f') ) {s = 7;}

                        else if ( (LA12_0=='L') ) {s = 8;}

                        else if ( (LA12_0=='e') ) {s = 9;}

                        else if ( (LA12_0=='n') ) {s = 10;}

                        else if ( (LA12_0=='v') ) {s = 11;}

                        else if ( (LA12_0=='!') ) {s = 12;}

                        else if ( (LA12_0=='&') ) {s = 13;}

                        else if ( (LA12_0=='<') ) {s = 14;}

                        else if ( (LA12_0=='=') ) {s = 15;}

                        else if ( (LA12_0=='>') ) {s = 16;}

                        else if ( (LA12_0=='|') ) {s = 17;}

                        else if ( (LA12_0=='(') ) {s = 18;}

                        else if ( (LA12_0==')') ) {s = 19;}

                        else if ( (LA12_0=='+') ) {s = 20;}

                        else if ( (LA12_0==',') ) {s = 21;}

                        else if ( (LA12_0=='.') ) {s = 22;}

                        else if ( (LA12_0==':') ) {s = 23;}

                        else if ( (LA12_0=='{') ) {s = 24;}

                        else if ( (LA12_0=='}') ) {s = 25;}

                        else if ( (LA12_0=='^') ) {s = 26;}

                        else if ( ((LA12_0>='A' && LA12_0<='K')||(LA12_0>='M' && LA12_0<='O')||LA12_0=='Q'||(LA12_0>='T' && LA12_0<='Z')||LA12_0=='_'||LA12_0=='a'||(LA12_0>='c' && LA12_0<='d')||(LA12_0>='g' && LA12_0<='h')||(LA12_0>='j' && LA12_0<='m')||(LA12_0>='o' && LA12_0<='s')||LA12_0=='u'||(LA12_0>='w' && LA12_0<='z')) ) {s = 27;}

                        else if ( ((LA12_0>='0' && LA12_0<='9')) ) {s = 28;}

                        else if ( (LA12_0=='\"') ) {s = 29;}

                        else if ( (LA12_0=='\'') ) {s = 30;}

                        else if ( (LA12_0=='/') ) {s = 31;}

                        else if ( ((LA12_0>='\t' && LA12_0<='\n')||LA12_0=='\r'||LA12_0==' ') ) {s = 32;}

                        else if ( ((LA12_0>='\u0000' && LA12_0<='\b')||(LA12_0>='\u000B' && LA12_0<='\f')||(LA12_0>='\u000E' && LA12_0<='\u001F')||(LA12_0>='#' && LA12_0<='%')||LA12_0=='*'||LA12_0=='-'||LA12_0==';'||(LA12_0>='?' && LA12_0<='@')||(LA12_0>='[' && LA12_0<=']')||LA12_0=='`'||(LA12_0>='~' && LA12_0<='\uFFFF')) ) {s = 33;}

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 12, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}