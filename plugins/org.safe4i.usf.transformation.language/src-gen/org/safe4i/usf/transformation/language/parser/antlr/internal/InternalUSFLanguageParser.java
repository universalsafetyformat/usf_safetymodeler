package org.safe4i.usf.transformation.language.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.safe4i.usf.transformation.language.services.USFLanguageGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
/*******************************************************************************
* Copyright (c) 2021 ScopeSET Technology Deutschland GmbH (https://www.scopeset.de) and others.
* This program and the accompanying materials are made available under the
* terms of the Eclipse Public License 2.0 which is available at
* http://www.eclipse.org/legal/epl-2.0.
* 
* SPDX-License-Identifier: EPL-2.0
*******************************************************************************/
@SuppressWarnings("all")
public class InternalUSFLanguageParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "PortDirectionINOUT", "PortDirectionUNSET", "PortDirectionOUT", "PortDirectionIN", "PRECONDITION", "Transform", "Boolean", "Integer", "RETURN", "String", "RULES", "False", "Float", "List", "Else", "Null", "True", "Void", "For", "Val", "Var", "ExclamationMarkEqualsSign", "AmpersandAmpersand", "LessThanSignEqualsSign", "EqualsSignEqualsSign", "GreaterThanSignEqualsSign", "If", "In", "VerticalLineVerticalLine", "ExclamationMark", "LeftParenthesis", "RightParenthesis", "PlusSign", "Comma", "FullStop", "Colon", "LessThanSign", "EqualsSign", "GreaterThanSign", "LeftCurlyBracket", "RightCurlyBracket", "RULE_BEGIN", "RULE_END", "RULE_ID", "RULE_INT", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER"
    };
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


        public InternalUSFLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalUSFLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalUSFLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "InternalUSFLanguageParser.g"; }



     	private USFLanguageGrammarAccess grammarAccess;

        public InternalUSFLanguageParser(TokenStream input, USFLanguageGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Transformation";
       	}

       	@Override
       	protected USFLanguageGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleTransformation"
    // InternalUSFLanguageParser.g:63:1: entryRuleTransformation returns [EObject current=null] : iv_ruleTransformation= ruleTransformation EOF ;
    public final EObject entryRuleTransformation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransformation = null;



        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");

        try {
            // InternalUSFLanguageParser.g:65:2: (iv_ruleTransformation= ruleTransformation EOF )
            // InternalUSFLanguageParser.g:66:2: iv_ruleTransformation= ruleTransformation EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTransformationRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleTransformation=ruleTransformation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTransformation; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleTransformation"


    // $ANTLR start "ruleTransformation"
    // InternalUSFLanguageParser.g:75:1: ruleTransformation returns [EObject current=null] : ( () otherlv_1= Transform ( (lv_name_2_0= RULE_ID ) ) otherlv_3= LeftParenthesis this_BEGIN_4= RULE_BEGIN ( ( (lv_parameters_5_0= ruleParameter ) ) (otherlv_6= Comma ( (lv_parameters_7_0= ruleParameter ) ) )* )? otherlv_8= RightParenthesis (otherlv_9= Colon ( (lv_type_10_0= ruleTransformationType ) ) )? otherlv_11= LeftCurlyBracket this_END_12= RULE_END otherlv_13= PRECONDITION this_BEGIN_14= RULE_BEGIN ( (lv_preconditions_15_0= ruleExpression ) )* this_END_16= RULE_END otherlv_17= RULES this_BEGIN_18= RULE_BEGIN ( (lv_content_19_0= ruleExpression ) )* this_END_20= RULE_END (otherlv_21= RETURN this_BEGIN_22= RULE_BEGIN ( (lv_output_23_0= ruleExpression ) ) this_END_24= RULE_END )? otherlv_25= RightCurlyBracket ) ;
    public final EObject ruleTransformation() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token this_BEGIN_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_11=null;
        Token this_END_12=null;
        Token otherlv_13=null;
        Token this_BEGIN_14=null;
        Token this_END_16=null;
        Token otherlv_17=null;
        Token this_BEGIN_18=null;
        Token this_END_20=null;
        Token otherlv_21=null;
        Token this_BEGIN_22=null;
        Token this_END_24=null;
        Token otherlv_25=null;
        EObject lv_parameters_5_0 = null;

        EObject lv_parameters_7_0 = null;

        EObject lv_type_10_0 = null;

        EObject lv_preconditions_15_0 = null;

        EObject lv_content_19_0 = null;

        EObject lv_output_23_0 = null;



        	enterRule();
        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens("RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT");

        try {
            // InternalUSFLanguageParser.g:82:2: ( ( () otherlv_1= Transform ( (lv_name_2_0= RULE_ID ) ) otherlv_3= LeftParenthesis this_BEGIN_4= RULE_BEGIN ( ( (lv_parameters_5_0= ruleParameter ) ) (otherlv_6= Comma ( (lv_parameters_7_0= ruleParameter ) ) )* )? otherlv_8= RightParenthesis (otherlv_9= Colon ( (lv_type_10_0= ruleTransformationType ) ) )? otherlv_11= LeftCurlyBracket this_END_12= RULE_END otherlv_13= PRECONDITION this_BEGIN_14= RULE_BEGIN ( (lv_preconditions_15_0= ruleExpression ) )* this_END_16= RULE_END otherlv_17= RULES this_BEGIN_18= RULE_BEGIN ( (lv_content_19_0= ruleExpression ) )* this_END_20= RULE_END (otherlv_21= RETURN this_BEGIN_22= RULE_BEGIN ( (lv_output_23_0= ruleExpression ) ) this_END_24= RULE_END )? otherlv_25= RightCurlyBracket ) )
            // InternalUSFLanguageParser.g:83:2: ( () otherlv_1= Transform ( (lv_name_2_0= RULE_ID ) ) otherlv_3= LeftParenthesis this_BEGIN_4= RULE_BEGIN ( ( (lv_parameters_5_0= ruleParameter ) ) (otherlv_6= Comma ( (lv_parameters_7_0= ruleParameter ) ) )* )? otherlv_8= RightParenthesis (otherlv_9= Colon ( (lv_type_10_0= ruleTransformationType ) ) )? otherlv_11= LeftCurlyBracket this_END_12= RULE_END otherlv_13= PRECONDITION this_BEGIN_14= RULE_BEGIN ( (lv_preconditions_15_0= ruleExpression ) )* this_END_16= RULE_END otherlv_17= RULES this_BEGIN_18= RULE_BEGIN ( (lv_content_19_0= ruleExpression ) )* this_END_20= RULE_END (otherlv_21= RETURN this_BEGIN_22= RULE_BEGIN ( (lv_output_23_0= ruleExpression ) ) this_END_24= RULE_END )? otherlv_25= RightCurlyBracket )
            {
            // InternalUSFLanguageParser.g:83:2: ( () otherlv_1= Transform ( (lv_name_2_0= RULE_ID ) ) otherlv_3= LeftParenthesis this_BEGIN_4= RULE_BEGIN ( ( (lv_parameters_5_0= ruleParameter ) ) (otherlv_6= Comma ( (lv_parameters_7_0= ruleParameter ) ) )* )? otherlv_8= RightParenthesis (otherlv_9= Colon ( (lv_type_10_0= ruleTransformationType ) ) )? otherlv_11= LeftCurlyBracket this_END_12= RULE_END otherlv_13= PRECONDITION this_BEGIN_14= RULE_BEGIN ( (lv_preconditions_15_0= ruleExpression ) )* this_END_16= RULE_END otherlv_17= RULES this_BEGIN_18= RULE_BEGIN ( (lv_content_19_0= ruleExpression ) )* this_END_20= RULE_END (otherlv_21= RETURN this_BEGIN_22= RULE_BEGIN ( (lv_output_23_0= ruleExpression ) ) this_END_24= RULE_END )? otherlv_25= RightCurlyBracket )
            // InternalUSFLanguageParser.g:84:3: () otherlv_1= Transform ( (lv_name_2_0= RULE_ID ) ) otherlv_3= LeftParenthesis this_BEGIN_4= RULE_BEGIN ( ( (lv_parameters_5_0= ruleParameter ) ) (otherlv_6= Comma ( (lv_parameters_7_0= ruleParameter ) ) )* )? otherlv_8= RightParenthesis (otherlv_9= Colon ( (lv_type_10_0= ruleTransformationType ) ) )? otherlv_11= LeftCurlyBracket this_END_12= RULE_END otherlv_13= PRECONDITION this_BEGIN_14= RULE_BEGIN ( (lv_preconditions_15_0= ruleExpression ) )* this_END_16= RULE_END otherlv_17= RULES this_BEGIN_18= RULE_BEGIN ( (lv_content_19_0= ruleExpression ) )* this_END_20= RULE_END (otherlv_21= RETURN this_BEGIN_22= RULE_BEGIN ( (lv_output_23_0= ruleExpression ) ) this_END_24= RULE_END )? otherlv_25= RightCurlyBracket
            {
            // InternalUSFLanguageParser.g:84:3: ()
            // InternalUSFLanguageParser.g:85:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getTransformationAccess().getTransformationAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,Transform,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getTransformationAccess().getTransformKeyword_1());
              		
            }
            // InternalUSFLanguageParser.g:95:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalUSFLanguageParser.g:96:4: (lv_name_2_0= RULE_ID )
            {
            // InternalUSFLanguageParser.g:96:4: (lv_name_2_0= RULE_ID )
            // InternalUSFLanguageParser.g:97:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_2_0, grammarAccess.getTransformationAccess().getNameIDTerminalRuleCall_2_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getTransformationRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_2_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            otherlv_3=(Token)match(input,LeftParenthesis,FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getTransformationAccess().getLeftParenthesisKeyword_3());
              		
            }
            this_BEGIN_4=(Token)match(input,RULE_BEGIN,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_BEGIN_4, grammarAccess.getTransformationAccess().getBEGINTerminalRuleCall_4());
              		
            }
            // InternalUSFLanguageParser.g:121:3: ( ( (lv_parameters_5_0= ruleParameter ) ) (otherlv_6= Comma ( (lv_parameters_7_0= ruleParameter ) ) )* )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_ID) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // InternalUSFLanguageParser.g:122:4: ( (lv_parameters_5_0= ruleParameter ) ) (otherlv_6= Comma ( (lv_parameters_7_0= ruleParameter ) ) )*
                    {
                    // InternalUSFLanguageParser.g:122:4: ( (lv_parameters_5_0= ruleParameter ) )
                    // InternalUSFLanguageParser.g:123:5: (lv_parameters_5_0= ruleParameter )
                    {
                    // InternalUSFLanguageParser.g:123:5: (lv_parameters_5_0= ruleParameter )
                    // InternalUSFLanguageParser.g:124:6: lv_parameters_5_0= ruleParameter
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getTransformationAccess().getParametersParameterParserRuleCall_5_0_0());
                      					
                    }
                    pushFollow(FOLLOW_7);
                    lv_parameters_5_0=ruleParameter();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getTransformationRule());
                      						}
                      						add(
                      							current,
                      							"parameters",
                      							lv_parameters_5_0,
                      							"org.safe4i.usf.transformation.language.USFLanguage.Parameter");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalUSFLanguageParser.g:141:4: (otherlv_6= Comma ( (lv_parameters_7_0= ruleParameter ) ) )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==Comma) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // InternalUSFLanguageParser.g:142:5: otherlv_6= Comma ( (lv_parameters_7_0= ruleParameter ) )
                    	    {
                    	    otherlv_6=(Token)match(input,Comma,FOLLOW_3); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_6, grammarAccess.getTransformationAccess().getCommaKeyword_5_1_0());
                    	      				
                    	    }
                    	    // InternalUSFLanguageParser.g:146:5: ( (lv_parameters_7_0= ruleParameter ) )
                    	    // InternalUSFLanguageParser.g:147:6: (lv_parameters_7_0= ruleParameter )
                    	    {
                    	    // InternalUSFLanguageParser.g:147:6: (lv_parameters_7_0= ruleParameter )
                    	    // InternalUSFLanguageParser.g:148:7: lv_parameters_7_0= ruleParameter
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getTransformationAccess().getParametersParameterParserRuleCall_5_1_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_7);
                    	    lv_parameters_7_0=ruleParameter();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getTransformationRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"parameters",
                    	      								lv_parameters_7_0,
                    	      								"org.safe4i.usf.transformation.language.USFLanguage.Parameter");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop1;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_8=(Token)match(input,RightParenthesis,FOLLOW_8); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_8, grammarAccess.getTransformationAccess().getRightParenthesisKeyword_6());
              		
            }
            // InternalUSFLanguageParser.g:171:3: (otherlv_9= Colon ( (lv_type_10_0= ruleTransformationType ) ) )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==Colon) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // InternalUSFLanguageParser.g:172:4: otherlv_9= Colon ( (lv_type_10_0= ruleTransformationType ) )
                    {
                    otherlv_9=(Token)match(input,Colon,FOLLOW_9); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_9, grammarAccess.getTransformationAccess().getColonKeyword_7_0());
                      			
                    }
                    // InternalUSFLanguageParser.g:176:4: ( (lv_type_10_0= ruleTransformationType ) )
                    // InternalUSFLanguageParser.g:177:5: (lv_type_10_0= ruleTransformationType )
                    {
                    // InternalUSFLanguageParser.g:177:5: (lv_type_10_0= ruleTransformationType )
                    // InternalUSFLanguageParser.g:178:6: lv_type_10_0= ruleTransformationType
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getTransformationAccess().getTypeTransformationTypeParserRuleCall_7_1_0());
                      					
                    }
                    pushFollow(FOLLOW_10);
                    lv_type_10_0=ruleTransformationType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getTransformationRule());
                      						}
                      						set(
                      							current,
                      							"type",
                      							lv_type_10_0,
                      							"org.safe4i.usf.transformation.language.USFLanguage.TransformationType");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_11=(Token)match(input,LeftCurlyBracket,FOLLOW_11); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_11, grammarAccess.getTransformationAccess().getLeftCurlyBracketKeyword_8());
              		
            }
            this_END_12=(Token)match(input,RULE_END,FOLLOW_12); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_END_12, grammarAccess.getTransformationAccess().getENDTerminalRuleCall_9());
              		
            }
            otherlv_13=(Token)match(input,PRECONDITION,FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_13, grammarAccess.getTransformationAccess().getPRECONDITIONKeyword_10());
              		
            }
            this_BEGIN_14=(Token)match(input,RULE_BEGIN,FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_BEGIN_14, grammarAccess.getTransformationAccess().getBEGINTerminalRuleCall_11());
              		
            }
            // InternalUSFLanguageParser.g:212:3: ( (lv_preconditions_15_0= ruleExpression ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( ((LA4_0>=PortDirectionINOUT && LA4_0<=PortDirectionIN)||LA4_0==False||(LA4_0>=Null && LA4_0<=True)||(LA4_0>=For && LA4_0<=Var)||LA4_0==If||(LA4_0>=RULE_ID && LA4_0<=RULE_STRING)) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // InternalUSFLanguageParser.g:213:4: (lv_preconditions_15_0= ruleExpression )
            	    {
            	    // InternalUSFLanguageParser.g:213:4: (lv_preconditions_15_0= ruleExpression )
            	    // InternalUSFLanguageParser.g:214:5: lv_preconditions_15_0= ruleExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getTransformationAccess().getPreconditionsExpressionParserRuleCall_12_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_13);
            	    lv_preconditions_15_0=ruleExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getTransformationRule());
            	      					}
            	      					add(
            	      						current,
            	      						"preconditions",
            	      						lv_preconditions_15_0,
            	      						"org.safe4i.usf.transformation.language.USFLanguage.Expression");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);

            this_END_16=(Token)match(input,RULE_END,FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_END_16, grammarAccess.getTransformationAccess().getENDTerminalRuleCall_13());
              		
            }
            otherlv_17=(Token)match(input,RULES,FOLLOW_5); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_17, grammarAccess.getTransformationAccess().getRULESKeyword_14());
              		
            }
            this_BEGIN_18=(Token)match(input,RULE_BEGIN,FOLLOW_13); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_BEGIN_18, grammarAccess.getTransformationAccess().getBEGINTerminalRuleCall_15());
              		
            }
            // InternalUSFLanguageParser.g:243:3: ( (lv_content_19_0= ruleExpression ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( ((LA5_0>=PortDirectionINOUT && LA5_0<=PortDirectionIN)||LA5_0==False||(LA5_0>=Null && LA5_0<=True)||(LA5_0>=For && LA5_0<=Var)||LA5_0==If||(LA5_0>=RULE_ID && LA5_0<=RULE_STRING)) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalUSFLanguageParser.g:244:4: (lv_content_19_0= ruleExpression )
            	    {
            	    // InternalUSFLanguageParser.g:244:4: (lv_content_19_0= ruleExpression )
            	    // InternalUSFLanguageParser.g:245:5: lv_content_19_0= ruleExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getTransformationAccess().getContentExpressionParserRuleCall_16_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_13);
            	    lv_content_19_0=ruleExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getTransformationRule());
            	      					}
            	      					add(
            	      						current,
            	      						"content",
            	      						lv_content_19_0,
            	      						"org.safe4i.usf.transformation.language.USFLanguage.Expression");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            this_END_20=(Token)match(input,RULE_END,FOLLOW_15); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(this_END_20, grammarAccess.getTransformationAccess().getENDTerminalRuleCall_17());
              		
            }
            // InternalUSFLanguageParser.g:266:3: (otherlv_21= RETURN this_BEGIN_22= RULE_BEGIN ( (lv_output_23_0= ruleExpression ) ) this_END_24= RULE_END )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==RETURN) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalUSFLanguageParser.g:267:4: otherlv_21= RETURN this_BEGIN_22= RULE_BEGIN ( (lv_output_23_0= ruleExpression ) ) this_END_24= RULE_END
                    {
                    otherlv_21=(Token)match(input,RETURN,FOLLOW_5); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_21, grammarAccess.getTransformationAccess().getRETURNKeyword_18_0());
                      			
                    }
                    this_BEGIN_22=(Token)match(input,RULE_BEGIN,FOLLOW_16); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_BEGIN_22, grammarAccess.getTransformationAccess().getBEGINTerminalRuleCall_18_1());
                      			
                    }
                    // InternalUSFLanguageParser.g:275:4: ( (lv_output_23_0= ruleExpression ) )
                    // InternalUSFLanguageParser.g:276:5: (lv_output_23_0= ruleExpression )
                    {
                    // InternalUSFLanguageParser.g:276:5: (lv_output_23_0= ruleExpression )
                    // InternalUSFLanguageParser.g:277:6: lv_output_23_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getTransformationAccess().getOutputExpressionParserRuleCall_18_2_0());
                      					
                    }
                    pushFollow(FOLLOW_11);
                    lv_output_23_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getTransformationRule());
                      						}
                      						set(
                      							current,
                      							"output",
                      							lv_output_23_0,
                      							"org.safe4i.usf.transformation.language.USFLanguage.Expression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    this_END_24=(Token)match(input,RULE_END,FOLLOW_17); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_END_24, grammarAccess.getTransformationAccess().getENDTerminalRuleCall_18_3());
                      			
                    }

                    }
                    break;

            }

            otherlv_25=(Token)match(input,RightCurlyBracket,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_25, grammarAccess.getTransformationAccess().getRightCurlyBracketKeyword_19());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleTransformation"


    // $ANTLR start "entryRuleExpression"
    // InternalUSFLanguageParser.g:310:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // InternalUSFLanguageParser.g:310:51: (iv_ruleExpression= ruleExpression EOF )
            // InternalUSFLanguageParser.g:311:2: iv_ruleExpression= ruleExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleExpression=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleExpression"


    // $ANTLR start "ruleExpression"
    // InternalUSFLanguageParser.g:317:1: ruleExpression returns [EObject current=null] : (this_AssignmentOrVariableDeclaration_0= ruleAssignmentOrVariableDeclaration | this_NullLiteral_1= ruleNullLiteral | this_BooleanLiteral_2= ruleBooleanLiteral | ( ( ( () For LeftParenthesis ( ( ruleParameter ) ) In ) )=>this_ForLoopExpression_3= ruleForLoopExpression ) | this_IfExpression_4= ruleIfExpression | this_ConcatenationExpression_5= ruleConcatenationExpression ) ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject this_AssignmentOrVariableDeclaration_0 = null;

        EObject this_NullLiteral_1 = null;

        EObject this_BooleanLiteral_2 = null;

        EObject this_ForLoopExpression_3 = null;

        EObject this_IfExpression_4 = null;

        EObject this_ConcatenationExpression_5 = null;



        	enterRule();

        try {
            // InternalUSFLanguageParser.g:323:2: ( (this_AssignmentOrVariableDeclaration_0= ruleAssignmentOrVariableDeclaration | this_NullLiteral_1= ruleNullLiteral | this_BooleanLiteral_2= ruleBooleanLiteral | ( ( ( () For LeftParenthesis ( ( ruleParameter ) ) In ) )=>this_ForLoopExpression_3= ruleForLoopExpression ) | this_IfExpression_4= ruleIfExpression | this_ConcatenationExpression_5= ruleConcatenationExpression ) )
            // InternalUSFLanguageParser.g:324:2: (this_AssignmentOrVariableDeclaration_0= ruleAssignmentOrVariableDeclaration | this_NullLiteral_1= ruleNullLiteral | this_BooleanLiteral_2= ruleBooleanLiteral | ( ( ( () For LeftParenthesis ( ( ruleParameter ) ) In ) )=>this_ForLoopExpression_3= ruleForLoopExpression ) | this_IfExpression_4= ruleIfExpression | this_ConcatenationExpression_5= ruleConcatenationExpression )
            {
            // InternalUSFLanguageParser.g:324:2: (this_AssignmentOrVariableDeclaration_0= ruleAssignmentOrVariableDeclaration | this_NullLiteral_1= ruleNullLiteral | this_BooleanLiteral_2= ruleBooleanLiteral | ( ( ( () For LeftParenthesis ( ( ruleParameter ) ) In ) )=>this_ForLoopExpression_3= ruleForLoopExpression ) | this_IfExpression_4= ruleIfExpression | this_ConcatenationExpression_5= ruleConcatenationExpression )
            int alt7=6;
            int LA7_0 = input.LA(1);

            if ( ((LA7_0>=Val && LA7_0<=Var)) ) {
                alt7=1;
            }
            else if ( (LA7_0==RULE_ID) ) {
                int LA7_2 = input.LA(2);

                if ( (LA7_2==EqualsSign) ) {
                    alt7=1;
                }
                else if ( (LA7_2==EOF||(LA7_2>=PortDirectionINOUT && LA7_2<=PortDirectionIN)||LA7_2==False||(LA7_2>=Null && LA7_2<=True)||(LA7_2>=For && LA7_2<=Var)||LA7_2==If||(LA7_2>=LeftParenthesis && LA7_2<=FullStop)||(LA7_2>=RULE_END && LA7_2<=RULE_STRING)) ) {
                    alt7=6;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 7, 2, input);

                    throw nvae;
                }
            }
            else if ( (LA7_0==Null) ) {
                alt7=2;
            }
            else if ( (LA7_0==False||LA7_0==True) ) {
                alt7=3;
            }
            else if ( (LA7_0==For) && (synpred1_InternalUSFLanguageParser())) {
                alt7=4;
            }
            else if ( (LA7_0==If) ) {
                alt7=5;
            }
            else if ( ((LA7_0>=PortDirectionINOUT && LA7_0<=PortDirectionIN)||(LA7_0>=RULE_INT && LA7_0<=RULE_STRING)) ) {
                alt7=6;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // InternalUSFLanguageParser.g:325:3: this_AssignmentOrVariableDeclaration_0= ruleAssignmentOrVariableDeclaration
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getExpressionAccess().getAssignmentOrVariableDeclarationParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_AssignmentOrVariableDeclaration_0=ruleAssignmentOrVariableDeclaration();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_AssignmentOrVariableDeclaration_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalUSFLanguageParser.g:334:3: this_NullLiteral_1= ruleNullLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getExpressionAccess().getNullLiteralParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_NullLiteral_1=ruleNullLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_NullLiteral_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalUSFLanguageParser.g:343:3: this_BooleanLiteral_2= ruleBooleanLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getExpressionAccess().getBooleanLiteralParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_BooleanLiteral_2=ruleBooleanLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_BooleanLiteral_2;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalUSFLanguageParser.g:352:3: ( ( ( () For LeftParenthesis ( ( ruleParameter ) ) In ) )=>this_ForLoopExpression_3= ruleForLoopExpression )
                    {
                    // InternalUSFLanguageParser.g:352:3: ( ( ( () For LeftParenthesis ( ( ruleParameter ) ) In ) )=>this_ForLoopExpression_3= ruleForLoopExpression )
                    // InternalUSFLanguageParser.g:353:4: ( ( () For LeftParenthesis ( ( ruleParameter ) ) In ) )=>this_ForLoopExpression_3= ruleForLoopExpression
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getExpressionAccess().getForLoopExpressionParserRuleCall_3());
                      			
                    }
                    pushFollow(FOLLOW_2);
                    this_ForLoopExpression_3=ruleForLoopExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_ForLoopExpression_3;
                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalUSFLanguageParser.g:376:3: this_IfExpression_4= ruleIfExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getExpressionAccess().getIfExpressionParserRuleCall_4());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_IfExpression_4=ruleIfExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_IfExpression_4;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 6 :
                    // InternalUSFLanguageParser.g:385:3: this_ConcatenationExpression_5= ruleConcatenationExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getExpressionAccess().getConcatenationExpressionParserRuleCall_5());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ConcatenationExpression_5=ruleConcatenationExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ConcatenationExpression_5;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRuleTransformationType"
    // InternalUSFLanguageParser.g:397:1: entryRuleTransformationType returns [EObject current=null] : iv_ruleTransformationType= ruleTransformationType EOF ;
    public final EObject entryRuleTransformationType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransformationType = null;


        try {
            // InternalUSFLanguageParser.g:397:59: (iv_ruleTransformationType= ruleTransformationType EOF )
            // InternalUSFLanguageParser.g:398:2: iv_ruleTransformationType= ruleTransformationType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTransformationTypeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleTransformationType=ruleTransformationType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTransformationType; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTransformationType"


    // $ANTLR start "ruleTransformationType"
    // InternalUSFLanguageParser.g:404:1: ruleTransformationType returns [EObject current=null] : (this_TypeBasedTransformationType_0= ruleTypeBasedTransformationType | this_EClassBasedTransformationType_1= ruleEClassBasedTransformationType | this_ListBasedTransformationType_2= ruleListBasedTransformationType ) ;
    public final EObject ruleTransformationType() throws RecognitionException {
        EObject current = null;

        EObject this_TypeBasedTransformationType_0 = null;

        EObject this_EClassBasedTransformationType_1 = null;

        EObject this_ListBasedTransformationType_2 = null;



        	enterRule();

        try {
            // InternalUSFLanguageParser.g:410:2: ( (this_TypeBasedTransformationType_0= ruleTypeBasedTransformationType | this_EClassBasedTransformationType_1= ruleEClassBasedTransformationType | this_ListBasedTransformationType_2= ruleListBasedTransformationType ) )
            // InternalUSFLanguageParser.g:411:2: (this_TypeBasedTransformationType_0= ruleTypeBasedTransformationType | this_EClassBasedTransformationType_1= ruleEClassBasedTransformationType | this_ListBasedTransformationType_2= ruleListBasedTransformationType )
            {
            // InternalUSFLanguageParser.g:411:2: (this_TypeBasedTransformationType_0= ruleTypeBasedTransformationType | this_EClassBasedTransformationType_1= ruleEClassBasedTransformationType | this_ListBasedTransformationType_2= ruleListBasedTransformationType )
            int alt8=3;
            switch ( input.LA(1) ) {
            case Boolean:
            case Integer:
            case String:
            case Float:
            case Void:
                {
                alt8=1;
                }
                break;
            case RULE_ID:
                {
                alt8=2;
                }
                break;
            case List:
                {
                alt8=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }

            switch (alt8) {
                case 1 :
                    // InternalUSFLanguageParser.g:412:3: this_TypeBasedTransformationType_0= ruleTypeBasedTransformationType
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getTransformationTypeAccess().getTypeBasedTransformationTypeParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_TypeBasedTransformationType_0=ruleTypeBasedTransformationType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_TypeBasedTransformationType_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalUSFLanguageParser.g:421:3: this_EClassBasedTransformationType_1= ruleEClassBasedTransformationType
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getTransformationTypeAccess().getEClassBasedTransformationTypeParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_EClassBasedTransformationType_1=ruleEClassBasedTransformationType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_EClassBasedTransformationType_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalUSFLanguageParser.g:430:3: this_ListBasedTransformationType_2= ruleListBasedTransformationType
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getTransformationTypeAccess().getListBasedTransformationTypeParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ListBasedTransformationType_2=ruleListBasedTransformationType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ListBasedTransformationType_2;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTransformationType"


    // $ANTLR start "entryRuleTypeBasedTransformationType"
    // InternalUSFLanguageParser.g:442:1: entryRuleTypeBasedTransformationType returns [EObject current=null] : iv_ruleTypeBasedTransformationType= ruleTypeBasedTransformationType EOF ;
    public final EObject entryRuleTypeBasedTransformationType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeBasedTransformationType = null;


        try {
            // InternalUSFLanguageParser.g:442:68: (iv_ruleTypeBasedTransformationType= ruleTypeBasedTransformationType EOF )
            // InternalUSFLanguageParser.g:443:2: iv_ruleTypeBasedTransformationType= ruleTypeBasedTransformationType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeBasedTransformationTypeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleTypeBasedTransformationType=ruleTypeBasedTransformationType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeBasedTransformationType; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTypeBasedTransformationType"


    // $ANTLR start "ruleTypeBasedTransformationType"
    // InternalUSFLanguageParser.g:449:1: ruleTypeBasedTransformationType returns [EObject current=null] : ( (lv_type_0_0= ruleTransformationTypes ) ) ;
    public final EObject ruleTypeBasedTransformationType() throws RecognitionException {
        EObject current = null;

        Enumerator lv_type_0_0 = null;



        	enterRule();

        try {
            // InternalUSFLanguageParser.g:455:2: ( ( (lv_type_0_0= ruleTransformationTypes ) ) )
            // InternalUSFLanguageParser.g:456:2: ( (lv_type_0_0= ruleTransformationTypes ) )
            {
            // InternalUSFLanguageParser.g:456:2: ( (lv_type_0_0= ruleTransformationTypes ) )
            // InternalUSFLanguageParser.g:457:3: (lv_type_0_0= ruleTransformationTypes )
            {
            // InternalUSFLanguageParser.g:457:3: (lv_type_0_0= ruleTransformationTypes )
            // InternalUSFLanguageParser.g:458:4: lv_type_0_0= ruleTransformationTypes
            {
            if ( state.backtracking==0 ) {

              				newCompositeNode(grammarAccess.getTypeBasedTransformationTypeAccess().getTypeTransformationTypesEnumRuleCall_0());
              			
            }
            pushFollow(FOLLOW_2);
            lv_type_0_0=ruleTransformationTypes();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElementForParent(grammarAccess.getTypeBasedTransformationTypeRule());
              				}
              				set(
              					current,
              					"type",
              					lv_type_0_0,
              					"org.safe4i.usf.transformation.language.USFLanguage.TransformationTypes");
              				afterParserOrEnumRuleCall();
              			
            }

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTypeBasedTransformationType"


    // $ANTLR start "entryRuleEClassBasedTransformationType"
    // InternalUSFLanguageParser.g:478:1: entryRuleEClassBasedTransformationType returns [EObject current=null] : iv_ruleEClassBasedTransformationType= ruleEClassBasedTransformationType EOF ;
    public final EObject entryRuleEClassBasedTransformationType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEClassBasedTransformationType = null;


        try {
            // InternalUSFLanguageParser.g:478:70: (iv_ruleEClassBasedTransformationType= ruleEClassBasedTransformationType EOF )
            // InternalUSFLanguageParser.g:479:2: iv_ruleEClassBasedTransformationType= ruleEClassBasedTransformationType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEClassBasedTransformationTypeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEClassBasedTransformationType=ruleEClassBasedTransformationType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEClassBasedTransformationType; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEClassBasedTransformationType"


    // $ANTLR start "ruleEClassBasedTransformationType"
    // InternalUSFLanguageParser.g:485:1: ruleEClassBasedTransformationType returns [EObject current=null] : ( () ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleEClassBasedTransformationType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalUSFLanguageParser.g:491:2: ( ( () ( (otherlv_1= RULE_ID ) ) ) )
            // InternalUSFLanguageParser.g:492:2: ( () ( (otherlv_1= RULE_ID ) ) )
            {
            // InternalUSFLanguageParser.g:492:2: ( () ( (otherlv_1= RULE_ID ) ) )
            // InternalUSFLanguageParser.g:493:3: () ( (otherlv_1= RULE_ID ) )
            {
            // InternalUSFLanguageParser.g:493:3: ()
            // InternalUSFLanguageParser.g:494:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getEClassBasedTransformationTypeAccess().getEClassBasedTransformationTypeAction_0(),
              					current);
              			
            }

            }

            // InternalUSFLanguageParser.g:500:3: ( (otherlv_1= RULE_ID ) )
            // InternalUSFLanguageParser.g:501:4: (otherlv_1= RULE_ID )
            {
            // InternalUSFLanguageParser.g:501:4: (otherlv_1= RULE_ID )
            // InternalUSFLanguageParser.g:502:5: otherlv_1= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getEClassBasedTransformationTypeRule());
              					}
              				
            }
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_1, grammarAccess.getEClassBasedTransformationTypeAccess().getTypeEClassCrossReference_1_0());
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEClassBasedTransformationType"


    // $ANTLR start "entryRuleListBasedTransformationType"
    // InternalUSFLanguageParser.g:517:1: entryRuleListBasedTransformationType returns [EObject current=null] : iv_ruleListBasedTransformationType= ruleListBasedTransformationType EOF ;
    public final EObject entryRuleListBasedTransformationType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleListBasedTransformationType = null;


        try {
            // InternalUSFLanguageParser.g:517:68: (iv_ruleListBasedTransformationType= ruleListBasedTransformationType EOF )
            // InternalUSFLanguageParser.g:518:2: iv_ruleListBasedTransformationType= ruleListBasedTransformationType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getListBasedTransformationTypeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleListBasedTransformationType=ruleListBasedTransformationType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleListBasedTransformationType; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleListBasedTransformationType"


    // $ANTLR start "ruleListBasedTransformationType"
    // InternalUSFLanguageParser.g:524:1: ruleListBasedTransformationType returns [EObject current=null] : ( () otherlv_1= List otherlv_2= LessThanSign ( (otherlv_3= RULE_ID ) ) otherlv_4= GreaterThanSign ) ;
    public final EObject ruleListBasedTransformationType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;


        	enterRule();

        try {
            // InternalUSFLanguageParser.g:530:2: ( ( () otherlv_1= List otherlv_2= LessThanSign ( (otherlv_3= RULE_ID ) ) otherlv_4= GreaterThanSign ) )
            // InternalUSFLanguageParser.g:531:2: ( () otherlv_1= List otherlv_2= LessThanSign ( (otherlv_3= RULE_ID ) ) otherlv_4= GreaterThanSign )
            {
            // InternalUSFLanguageParser.g:531:2: ( () otherlv_1= List otherlv_2= LessThanSign ( (otherlv_3= RULE_ID ) ) otherlv_4= GreaterThanSign )
            // InternalUSFLanguageParser.g:532:3: () otherlv_1= List otherlv_2= LessThanSign ( (otherlv_3= RULE_ID ) ) otherlv_4= GreaterThanSign
            {
            // InternalUSFLanguageParser.g:532:3: ()
            // InternalUSFLanguageParser.g:533:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getListBasedTransformationTypeAccess().getListBasedTransformationTypeAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,List,FOLLOW_18); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getListBasedTransformationTypeAccess().getListKeyword_1());
              		
            }
            otherlv_2=(Token)match(input,LessThanSign,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getListBasedTransformationTypeAccess().getLessThanSignKeyword_2());
              		
            }
            // InternalUSFLanguageParser.g:547:3: ( (otherlv_3= RULE_ID ) )
            // InternalUSFLanguageParser.g:548:4: (otherlv_3= RULE_ID )
            {
            // InternalUSFLanguageParser.g:548:4: (otherlv_3= RULE_ID )
            // InternalUSFLanguageParser.g:549:5: otherlv_3= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getListBasedTransformationTypeRule());
              					}
              				
            }
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_19); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_3, grammarAccess.getListBasedTransformationTypeAccess().getTypeEClassCrossReference_3_0());
              				
            }

            }


            }

            otherlv_4=(Token)match(input,GreaterThanSign,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getListBasedTransformationTypeAccess().getGreaterThanSignKeyword_4());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleListBasedTransformationType"


    // $ANTLR start "entryRuleParameter"
    // InternalUSFLanguageParser.g:568:1: entryRuleParameter returns [EObject current=null] : iv_ruleParameter= ruleParameter EOF ;
    public final EObject entryRuleParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter = null;


        try {
            // InternalUSFLanguageParser.g:568:50: (iv_ruleParameter= ruleParameter EOF )
            // InternalUSFLanguageParser.g:569:2: iv_ruleParameter= ruleParameter EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParameterRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleParameter=ruleParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParameter; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleParameter"


    // $ANTLR start "ruleParameter"
    // InternalUSFLanguageParser.g:575:1: ruleParameter returns [EObject current=null] : (this_TypeBasedParameter_0= ruleTypeBasedParameter | this_EClassBasedParameter_1= ruleEClassBasedParameter | this_ListBasedParameter_2= ruleListBasedParameter ) ;
    public final EObject ruleParameter() throws RecognitionException {
        EObject current = null;

        EObject this_TypeBasedParameter_0 = null;

        EObject this_EClassBasedParameter_1 = null;

        EObject this_ListBasedParameter_2 = null;



        	enterRule();

        try {
            // InternalUSFLanguageParser.g:581:2: ( (this_TypeBasedParameter_0= ruleTypeBasedParameter | this_EClassBasedParameter_1= ruleEClassBasedParameter | this_ListBasedParameter_2= ruleListBasedParameter ) )
            // InternalUSFLanguageParser.g:582:2: (this_TypeBasedParameter_0= ruleTypeBasedParameter | this_EClassBasedParameter_1= ruleEClassBasedParameter | this_ListBasedParameter_2= ruleListBasedParameter )
            {
            // InternalUSFLanguageParser.g:582:2: (this_TypeBasedParameter_0= ruleTypeBasedParameter | this_EClassBasedParameter_1= ruleEClassBasedParameter | this_ListBasedParameter_2= ruleListBasedParameter )
            int alt9=3;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_ID) ) {
                int LA9_1 = input.LA(2);

                if ( (LA9_1==Colon) ) {
                    switch ( input.LA(3) ) {
                    case RULE_ID:
                        {
                        alt9=2;
                        }
                        break;
                    case Boolean:
                    case Integer:
                    case String:
                    case Float:
                    case Void:
                        {
                        alt9=1;
                        }
                        break;
                    case List:
                        {
                        alt9=3;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 9, 2, input);

                        throw nvae;
                    }

                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 9, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 9, 0, input);

                throw nvae;
            }
            switch (alt9) {
                case 1 :
                    // InternalUSFLanguageParser.g:583:3: this_TypeBasedParameter_0= ruleTypeBasedParameter
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getParameterAccess().getTypeBasedParameterParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_TypeBasedParameter_0=ruleTypeBasedParameter();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_TypeBasedParameter_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalUSFLanguageParser.g:592:3: this_EClassBasedParameter_1= ruleEClassBasedParameter
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getParameterAccess().getEClassBasedParameterParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_EClassBasedParameter_1=ruleEClassBasedParameter();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_EClassBasedParameter_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalUSFLanguageParser.g:601:3: this_ListBasedParameter_2= ruleListBasedParameter
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getParameterAccess().getListBasedParameterParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ListBasedParameter_2=ruleListBasedParameter();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ListBasedParameter_2;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleParameter"


    // $ANTLR start "entryRuleTypeBasedParameter"
    // InternalUSFLanguageParser.g:613:1: entryRuleTypeBasedParameter returns [EObject current=null] : iv_ruleTypeBasedParameter= ruleTypeBasedParameter EOF ;
    public final EObject entryRuleTypeBasedParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeBasedParameter = null;


        try {
            // InternalUSFLanguageParser.g:613:59: (iv_ruleTypeBasedParameter= ruleTypeBasedParameter EOF )
            // InternalUSFLanguageParser.g:614:2: iv_ruleTypeBasedParameter= ruleTypeBasedParameter EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeBasedParameterRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleTypeBasedParameter=ruleTypeBasedParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeBasedParameter; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTypeBasedParameter"


    // $ANTLR start "ruleTypeBasedParameter"
    // InternalUSFLanguageParser.g:620:1: ruleTypeBasedParameter returns [EObject current=null] : ( () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_type_3_0= ruleTransformationTypes ) ) ) ;
    public final EObject ruleTypeBasedParameter() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Enumerator lv_type_3_0 = null;



        	enterRule();

        try {
            // InternalUSFLanguageParser.g:626:2: ( ( () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_type_3_0= ruleTransformationTypes ) ) ) )
            // InternalUSFLanguageParser.g:627:2: ( () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_type_3_0= ruleTransformationTypes ) ) )
            {
            // InternalUSFLanguageParser.g:627:2: ( () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_type_3_0= ruleTransformationTypes ) ) )
            // InternalUSFLanguageParser.g:628:3: () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (lv_type_3_0= ruleTransformationTypes ) )
            {
            // InternalUSFLanguageParser.g:628:3: ()
            // InternalUSFLanguageParser.g:629:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getTypeBasedParameterAccess().getTypeBasedParameterAction_0(),
              					current);
              			
            }

            }

            // InternalUSFLanguageParser.g:635:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalUSFLanguageParser.g:636:4: (lv_name_1_0= RULE_ID )
            {
            // InternalUSFLanguageParser.g:636:4: (lv_name_1_0= RULE_ID )
            // InternalUSFLanguageParser.g:637:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_20); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_1_0, grammarAccess.getTypeBasedParameterAccess().getNameIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getTypeBasedParameterRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_1_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            otherlv_2=(Token)match(input,Colon,FOLLOW_21); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getTypeBasedParameterAccess().getColonKeyword_2());
              		
            }
            // InternalUSFLanguageParser.g:657:3: ( (lv_type_3_0= ruleTransformationTypes ) )
            // InternalUSFLanguageParser.g:658:4: (lv_type_3_0= ruleTransformationTypes )
            {
            // InternalUSFLanguageParser.g:658:4: (lv_type_3_0= ruleTransformationTypes )
            // InternalUSFLanguageParser.g:659:5: lv_type_3_0= ruleTransformationTypes
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getTypeBasedParameterAccess().getTypeTransformationTypesEnumRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_type_3_0=ruleTransformationTypes();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getTypeBasedParameterRule());
              					}
              					set(
              						current,
              						"type",
              						lv_type_3_0,
              						"org.safe4i.usf.transformation.language.USFLanguage.TransformationTypes");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTypeBasedParameter"


    // $ANTLR start "entryRuleEClassBasedParameter"
    // InternalUSFLanguageParser.g:680:1: entryRuleEClassBasedParameter returns [EObject current=null] : iv_ruleEClassBasedParameter= ruleEClassBasedParameter EOF ;
    public final EObject entryRuleEClassBasedParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEClassBasedParameter = null;


        try {
            // InternalUSFLanguageParser.g:680:61: (iv_ruleEClassBasedParameter= ruleEClassBasedParameter EOF )
            // InternalUSFLanguageParser.g:681:2: iv_ruleEClassBasedParameter= ruleEClassBasedParameter EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEClassBasedParameterRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEClassBasedParameter=ruleEClassBasedParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEClassBasedParameter; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEClassBasedParameter"


    // $ANTLR start "ruleEClassBasedParameter"
    // InternalUSFLanguageParser.g:687:1: ruleEClassBasedParameter returns [EObject current=null] : ( () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (otherlv_3= RULE_ID ) ) ) ;
    public final EObject ruleEClassBasedParameter() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;


        	enterRule();

        try {
            // InternalUSFLanguageParser.g:693:2: ( ( () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (otherlv_3= RULE_ID ) ) ) )
            // InternalUSFLanguageParser.g:694:2: ( () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (otherlv_3= RULE_ID ) ) )
            {
            // InternalUSFLanguageParser.g:694:2: ( () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (otherlv_3= RULE_ID ) ) )
            // InternalUSFLanguageParser.g:695:3: () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon ( (otherlv_3= RULE_ID ) )
            {
            // InternalUSFLanguageParser.g:695:3: ()
            // InternalUSFLanguageParser.g:696:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getEClassBasedParameterAccess().getEClassBasedParameterAction_0(),
              					current);
              			
            }

            }

            // InternalUSFLanguageParser.g:702:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalUSFLanguageParser.g:703:4: (lv_name_1_0= RULE_ID )
            {
            // InternalUSFLanguageParser.g:703:4: (lv_name_1_0= RULE_ID )
            // InternalUSFLanguageParser.g:704:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_20); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_1_0, grammarAccess.getEClassBasedParameterAccess().getNameIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getEClassBasedParameterRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_1_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            otherlv_2=(Token)match(input,Colon,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getEClassBasedParameterAccess().getColonKeyword_2());
              		
            }
            // InternalUSFLanguageParser.g:724:3: ( (otherlv_3= RULE_ID ) )
            // InternalUSFLanguageParser.g:725:4: (otherlv_3= RULE_ID )
            {
            // InternalUSFLanguageParser.g:725:4: (otherlv_3= RULE_ID )
            // InternalUSFLanguageParser.g:726:5: otherlv_3= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getEClassBasedParameterRule());
              					}
              				
            }
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_3, grammarAccess.getEClassBasedParameterAccess().getTypeEClassCrossReference_3_0());
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEClassBasedParameter"


    // $ANTLR start "entryRuleListBasedParameter"
    // InternalUSFLanguageParser.g:741:1: entryRuleListBasedParameter returns [EObject current=null] : iv_ruleListBasedParameter= ruleListBasedParameter EOF ;
    public final EObject entryRuleListBasedParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleListBasedParameter = null;


        try {
            // InternalUSFLanguageParser.g:741:59: (iv_ruleListBasedParameter= ruleListBasedParameter EOF )
            // InternalUSFLanguageParser.g:742:2: iv_ruleListBasedParameter= ruleListBasedParameter EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getListBasedParameterRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleListBasedParameter=ruleListBasedParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleListBasedParameter; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleListBasedParameter"


    // $ANTLR start "ruleListBasedParameter"
    // InternalUSFLanguageParser.g:748:1: ruleListBasedParameter returns [EObject current=null] : ( () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon otherlv_3= List otherlv_4= LessThanSign ( (otherlv_5= RULE_ID ) ) otherlv_6= GreaterThanSign ) ;
    public final EObject ruleListBasedParameter() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;


        	enterRule();

        try {
            // InternalUSFLanguageParser.g:754:2: ( ( () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon otherlv_3= List otherlv_4= LessThanSign ( (otherlv_5= RULE_ID ) ) otherlv_6= GreaterThanSign ) )
            // InternalUSFLanguageParser.g:755:2: ( () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon otherlv_3= List otherlv_4= LessThanSign ( (otherlv_5= RULE_ID ) ) otherlv_6= GreaterThanSign )
            {
            // InternalUSFLanguageParser.g:755:2: ( () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon otherlv_3= List otherlv_4= LessThanSign ( (otherlv_5= RULE_ID ) ) otherlv_6= GreaterThanSign )
            // InternalUSFLanguageParser.g:756:3: () ( (lv_name_1_0= RULE_ID ) ) otherlv_2= Colon otherlv_3= List otherlv_4= LessThanSign ( (otherlv_5= RULE_ID ) ) otherlv_6= GreaterThanSign
            {
            // InternalUSFLanguageParser.g:756:3: ()
            // InternalUSFLanguageParser.g:757:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getListBasedParameterAccess().getListBasedParameterAction_0(),
              					current);
              			
            }

            }

            // InternalUSFLanguageParser.g:763:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalUSFLanguageParser.g:764:4: (lv_name_1_0= RULE_ID )
            {
            // InternalUSFLanguageParser.g:764:4: (lv_name_1_0= RULE_ID )
            // InternalUSFLanguageParser.g:765:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_20); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_1_0, grammarAccess.getListBasedParameterAccess().getNameIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getListBasedParameterRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_1_0,
              						"org.eclipse.xtext.common.Terminals.ID");
              				
            }

            }


            }

            otherlv_2=(Token)match(input,Colon,FOLLOW_22); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getListBasedParameterAccess().getColonKeyword_2());
              		
            }
            otherlv_3=(Token)match(input,List,FOLLOW_18); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getListBasedParameterAccess().getListKeyword_3());
              		
            }
            otherlv_4=(Token)match(input,LessThanSign,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getListBasedParameterAccess().getLessThanSignKeyword_4());
              		
            }
            // InternalUSFLanguageParser.g:793:3: ( (otherlv_5= RULE_ID ) )
            // InternalUSFLanguageParser.g:794:4: (otherlv_5= RULE_ID )
            {
            // InternalUSFLanguageParser.g:794:4: (otherlv_5= RULE_ID )
            // InternalUSFLanguageParser.g:795:5: otherlv_5= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getListBasedParameterRule());
              					}
              				
            }
            otherlv_5=(Token)match(input,RULE_ID,FOLLOW_19); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_5, grammarAccess.getListBasedParameterAccess().getTypeEClassCrossReference_5_0());
              				
            }

            }


            }

            otherlv_6=(Token)match(input,GreaterThanSign,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getListBasedParameterAccess().getGreaterThanSignKeyword_6());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleListBasedParameter"


    // $ANTLR start "entryRuleConcatenationExpression"
    // InternalUSFLanguageParser.g:814:1: entryRuleConcatenationExpression returns [EObject current=null] : iv_ruleConcatenationExpression= ruleConcatenationExpression EOF ;
    public final EObject entryRuleConcatenationExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConcatenationExpression = null;


        try {
            // InternalUSFLanguageParser.g:814:64: (iv_ruleConcatenationExpression= ruleConcatenationExpression EOF )
            // InternalUSFLanguageParser.g:815:2: iv_ruleConcatenationExpression= ruleConcatenationExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getConcatenationExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleConcatenationExpression=ruleConcatenationExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleConcatenationExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleConcatenationExpression"


    // $ANTLR start "ruleConcatenationExpression"
    // InternalUSFLanguageParser.g:821:1: ruleConcatenationExpression returns [EObject current=null] : (this_Primary_0= rulePrimary ( () otherlv_2= PlusSign ( (lv_right_3_0= rulePrimary ) ) )* ) ;
    public final EObject ruleConcatenationExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_Primary_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalUSFLanguageParser.g:827:2: ( (this_Primary_0= rulePrimary ( () otherlv_2= PlusSign ( (lv_right_3_0= rulePrimary ) ) )* ) )
            // InternalUSFLanguageParser.g:828:2: (this_Primary_0= rulePrimary ( () otherlv_2= PlusSign ( (lv_right_3_0= rulePrimary ) ) )* )
            {
            // InternalUSFLanguageParser.g:828:2: (this_Primary_0= rulePrimary ( () otherlv_2= PlusSign ( (lv_right_3_0= rulePrimary ) ) )* )
            // InternalUSFLanguageParser.g:829:3: this_Primary_0= rulePrimary ( () otherlv_2= PlusSign ( (lv_right_3_0= rulePrimary ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getConcatenationExpressionAccess().getPrimaryParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_23);
            this_Primary_0=rulePrimary();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_Primary_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalUSFLanguageParser.g:837:3: ( () otherlv_2= PlusSign ( (lv_right_3_0= rulePrimary ) ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==PlusSign) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // InternalUSFLanguageParser.g:838:4: () otherlv_2= PlusSign ( (lv_right_3_0= rulePrimary ) )
            	    {
            	    // InternalUSFLanguageParser.g:838:4: ()
            	    // InternalUSFLanguageParser.g:839:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getConcatenationExpressionAccess().getConcatenationExpressionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    otherlv_2=(Token)match(input,PlusSign,FOLLOW_16); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_2, grammarAccess.getConcatenationExpressionAccess().getPlusSignKeyword_1_1());
            	      			
            	    }
            	    // InternalUSFLanguageParser.g:849:4: ( (lv_right_3_0= rulePrimary ) )
            	    // InternalUSFLanguageParser.g:850:5: (lv_right_3_0= rulePrimary )
            	    {
            	    // InternalUSFLanguageParser.g:850:5: (lv_right_3_0= rulePrimary )
            	    // InternalUSFLanguageParser.g:851:6: lv_right_3_0= rulePrimary
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getConcatenationExpressionAccess().getRightPrimaryParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_23);
            	    lv_right_3_0=rulePrimary();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getConcatenationExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"org.safe4i.usf.transformation.language.USFLanguage.Primary");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleConcatenationExpression"


    // $ANTLR start "entryRulePrimary"
    // InternalUSFLanguageParser.g:873:1: entryRulePrimary returns [EObject current=null] : iv_rulePrimary= rulePrimary EOF ;
    public final EObject entryRulePrimary() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimary = null;


        try {
            // InternalUSFLanguageParser.g:873:48: (iv_rulePrimary= rulePrimary EOF )
            // InternalUSFLanguageParser.g:874:2: iv_rulePrimary= rulePrimary EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimaryRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePrimary=rulePrimary();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimary; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrimary"


    // $ANTLR start "rulePrimary"
    // InternalUSFLanguageParser.g:880:1: rulePrimary returns [EObject current=null] : (this_StringLiteral_0= ruleStringLiteral | this_NumberLiteral_1= ruleNumberLiteral | this_TypedMemberCallExpression_2= ruleTypedMemberCallExpression | this_FeatureCallExpression_3= ruleFeatureCallExpression | this_OperationCallExpression_4= ruleOperationCallExpression | this_PortDirectionLiteral_5= rulePortDirectionLiteral ) ;
    public final EObject rulePrimary() throws RecognitionException {
        EObject current = null;

        EObject this_StringLiteral_0 = null;

        EObject this_NumberLiteral_1 = null;

        EObject this_TypedMemberCallExpression_2 = null;

        EObject this_FeatureCallExpression_3 = null;

        EObject this_OperationCallExpression_4 = null;

        EObject this_PortDirectionLiteral_5 = null;



        	enterRule();

        try {
            // InternalUSFLanguageParser.g:886:2: ( (this_StringLiteral_0= ruleStringLiteral | this_NumberLiteral_1= ruleNumberLiteral | this_TypedMemberCallExpression_2= ruleTypedMemberCallExpression | this_FeatureCallExpression_3= ruleFeatureCallExpression | this_OperationCallExpression_4= ruleOperationCallExpression | this_PortDirectionLiteral_5= rulePortDirectionLiteral ) )
            // InternalUSFLanguageParser.g:887:2: (this_StringLiteral_0= ruleStringLiteral | this_NumberLiteral_1= ruleNumberLiteral | this_TypedMemberCallExpression_2= ruleTypedMemberCallExpression | this_FeatureCallExpression_3= ruleFeatureCallExpression | this_OperationCallExpression_4= ruleOperationCallExpression | this_PortDirectionLiteral_5= rulePortDirectionLiteral )
            {
            // InternalUSFLanguageParser.g:887:2: (this_StringLiteral_0= ruleStringLiteral | this_NumberLiteral_1= ruleNumberLiteral | this_TypedMemberCallExpression_2= ruleTypedMemberCallExpression | this_FeatureCallExpression_3= ruleFeatureCallExpression | this_OperationCallExpression_4= ruleOperationCallExpression | this_PortDirectionLiteral_5= rulePortDirectionLiteral )
            int alt11=6;
            switch ( input.LA(1) ) {
            case RULE_STRING:
                {
                alt11=1;
                }
                break;
            case RULE_INT:
                {
                alt11=2;
                }
                break;
            case RULE_ID:
                {
                switch ( input.LA(2) ) {
                case LeftParenthesis:
                    {
                    alt11=5;
                    }
                    break;
                case EOF:
                case PortDirectionINOUT:
                case PortDirectionUNSET:
                case PortDirectionOUT:
                case PortDirectionIN:
                case False:
                case Null:
                case True:
                case For:
                case Val:
                case Var:
                case If:
                case RightParenthesis:
                case PlusSign:
                case Comma:
                case RULE_END:
                case RULE_ID:
                case RULE_INT:
                case RULE_STRING:
                    {
                    alt11=3;
                    }
                    break;
                case FullStop:
                    {
                    alt11=4;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 11, 3, input);

                    throw nvae;
                }

                }
                break;
            case PortDirectionINOUT:
            case PortDirectionUNSET:
            case PortDirectionOUT:
            case PortDirectionIN:
                {
                alt11=6;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 11, 0, input);

                throw nvae;
            }

            switch (alt11) {
                case 1 :
                    // InternalUSFLanguageParser.g:888:3: this_StringLiteral_0= ruleStringLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getPrimaryAccess().getStringLiteralParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_StringLiteral_0=ruleStringLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_StringLiteral_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalUSFLanguageParser.g:897:3: this_NumberLiteral_1= ruleNumberLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getPrimaryAccess().getNumberLiteralParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_NumberLiteral_1=ruleNumberLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_NumberLiteral_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalUSFLanguageParser.g:906:3: this_TypedMemberCallExpression_2= ruleTypedMemberCallExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getPrimaryAccess().getTypedMemberCallExpressionParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_TypedMemberCallExpression_2=ruleTypedMemberCallExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_TypedMemberCallExpression_2;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalUSFLanguageParser.g:915:3: this_FeatureCallExpression_3= ruleFeatureCallExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getPrimaryAccess().getFeatureCallExpressionParserRuleCall_3());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_FeatureCallExpression_3=ruleFeatureCallExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_FeatureCallExpression_3;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalUSFLanguageParser.g:924:3: this_OperationCallExpression_4= ruleOperationCallExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getPrimaryAccess().getOperationCallExpressionParserRuleCall_4());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_OperationCallExpression_4=ruleOperationCallExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_OperationCallExpression_4;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 6 :
                    // InternalUSFLanguageParser.g:933:3: this_PortDirectionLiteral_5= rulePortDirectionLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getPrimaryAccess().getPortDirectionLiteralParserRuleCall_5());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_PortDirectionLiteral_5=rulePortDirectionLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_PortDirectionLiteral_5;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrimary"


    // $ANTLR start "entryRuleStringLiteral"
    // InternalUSFLanguageParser.g:945:1: entryRuleStringLiteral returns [EObject current=null] : iv_ruleStringLiteral= ruleStringLiteral EOF ;
    public final EObject entryRuleStringLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringLiteral = null;


        try {
            // InternalUSFLanguageParser.g:945:54: (iv_ruleStringLiteral= ruleStringLiteral EOF )
            // InternalUSFLanguageParser.g:946:2: iv_ruleStringLiteral= ruleStringLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStringLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleStringLiteral=ruleStringLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStringLiteral; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleStringLiteral"


    // $ANTLR start "ruleStringLiteral"
    // InternalUSFLanguageParser.g:952:1: ruleStringLiteral returns [EObject current=null] : ( (lv_value_0_0= RULE_STRING ) ) ;
    public final EObject ruleStringLiteral() throws RecognitionException {
        EObject current = null;

        Token lv_value_0_0=null;


        	enterRule();

        try {
            // InternalUSFLanguageParser.g:958:2: ( ( (lv_value_0_0= RULE_STRING ) ) )
            // InternalUSFLanguageParser.g:959:2: ( (lv_value_0_0= RULE_STRING ) )
            {
            // InternalUSFLanguageParser.g:959:2: ( (lv_value_0_0= RULE_STRING ) )
            // InternalUSFLanguageParser.g:960:3: (lv_value_0_0= RULE_STRING )
            {
            // InternalUSFLanguageParser.g:960:3: (lv_value_0_0= RULE_STRING )
            // InternalUSFLanguageParser.g:961:4: lv_value_0_0= RULE_STRING
            {
            lv_value_0_0=(Token)match(input,RULE_STRING,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(lv_value_0_0, grammarAccess.getStringLiteralAccess().getValueSTRINGTerminalRuleCall_0());
              			
            }
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElement(grammarAccess.getStringLiteralRule());
              				}
              				setWithLastConsumed(
              					current,
              					"value",
              					lv_value_0_0,
              					"org.eclipse.xtext.common.Terminals.STRING");
              			
            }

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleStringLiteral"


    // $ANTLR start "entryRuleNumberLiteral"
    // InternalUSFLanguageParser.g:980:1: entryRuleNumberLiteral returns [EObject current=null] : iv_ruleNumberLiteral= ruleNumberLiteral EOF ;
    public final EObject entryRuleNumberLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumberLiteral = null;


        try {
            // InternalUSFLanguageParser.g:980:54: (iv_ruleNumberLiteral= ruleNumberLiteral EOF )
            // InternalUSFLanguageParser.g:981:2: iv_ruleNumberLiteral= ruleNumberLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNumberLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleNumberLiteral=ruleNumberLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNumberLiteral; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNumberLiteral"


    // $ANTLR start "ruleNumberLiteral"
    // InternalUSFLanguageParser.g:987:1: ruleNumberLiteral returns [EObject current=null] : ( (lv_value_0_0= ruleNumber ) ) ;
    public final EObject ruleNumberLiteral() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;



        	enterRule();

        try {
            // InternalUSFLanguageParser.g:993:2: ( ( (lv_value_0_0= ruleNumber ) ) )
            // InternalUSFLanguageParser.g:994:2: ( (lv_value_0_0= ruleNumber ) )
            {
            // InternalUSFLanguageParser.g:994:2: ( (lv_value_0_0= ruleNumber ) )
            // InternalUSFLanguageParser.g:995:3: (lv_value_0_0= ruleNumber )
            {
            // InternalUSFLanguageParser.g:995:3: (lv_value_0_0= ruleNumber )
            // InternalUSFLanguageParser.g:996:4: lv_value_0_0= ruleNumber
            {
            if ( state.backtracking==0 ) {

              				newCompositeNode(grammarAccess.getNumberLiteralAccess().getValueNumberParserRuleCall_0());
              			
            }
            pushFollow(FOLLOW_2);
            lv_value_0_0=ruleNumber();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElementForParent(grammarAccess.getNumberLiteralRule());
              				}
              				set(
              					current,
              					"value",
              					lv_value_0_0,
              					"org.safe4i.usf.transformation.language.USFLanguage.Number");
              				afterParserOrEnumRuleCall();
              			
            }

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNumberLiteral"


    // $ANTLR start "entryRuleNullLiteral"
    // InternalUSFLanguageParser.g:1016:1: entryRuleNullLiteral returns [EObject current=null] : iv_ruleNullLiteral= ruleNullLiteral EOF ;
    public final EObject entryRuleNullLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNullLiteral = null;


        try {
            // InternalUSFLanguageParser.g:1016:52: (iv_ruleNullLiteral= ruleNullLiteral EOF )
            // InternalUSFLanguageParser.g:1017:2: iv_ruleNullLiteral= ruleNullLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNullLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleNullLiteral=ruleNullLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNullLiteral; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleNullLiteral"


    // $ANTLR start "ruleNullLiteral"
    // InternalUSFLanguageParser.g:1023:1: ruleNullLiteral returns [EObject current=null] : ( () otherlv_1= Null ) ;
    public final EObject ruleNullLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalUSFLanguageParser.g:1029:2: ( ( () otherlv_1= Null ) )
            // InternalUSFLanguageParser.g:1030:2: ( () otherlv_1= Null )
            {
            // InternalUSFLanguageParser.g:1030:2: ( () otherlv_1= Null )
            // InternalUSFLanguageParser.g:1031:3: () otherlv_1= Null
            {
            // InternalUSFLanguageParser.g:1031:3: ()
            // InternalUSFLanguageParser.g:1032:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getNullLiteralAccess().getNullLiteralAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,Null,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getNullLiteralAccess().getNullKeyword_1());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleNullLiteral"


    // $ANTLR start "entryRuleBooleanLiteral"
    // InternalUSFLanguageParser.g:1046:1: entryRuleBooleanLiteral returns [EObject current=null] : iv_ruleBooleanLiteral= ruleBooleanLiteral EOF ;
    public final EObject entryRuleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanLiteral = null;


        try {
            // InternalUSFLanguageParser.g:1046:55: (iv_ruleBooleanLiteral= ruleBooleanLiteral EOF )
            // InternalUSFLanguageParser.g:1047:2: iv_ruleBooleanLiteral= ruleBooleanLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBooleanLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBooleanLiteral=ruleBooleanLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBooleanLiteral; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBooleanLiteral"


    // $ANTLR start "ruleBooleanLiteral"
    // InternalUSFLanguageParser.g:1053:1: ruleBooleanLiteral returns [EObject current=null] : ( () (otherlv_1= False | ( (lv_isTrue_2_0= True ) ) ) ) ;
    public final EObject ruleBooleanLiteral() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_isTrue_2_0=null;


        	enterRule();

        try {
            // InternalUSFLanguageParser.g:1059:2: ( ( () (otherlv_1= False | ( (lv_isTrue_2_0= True ) ) ) ) )
            // InternalUSFLanguageParser.g:1060:2: ( () (otherlv_1= False | ( (lv_isTrue_2_0= True ) ) ) )
            {
            // InternalUSFLanguageParser.g:1060:2: ( () (otherlv_1= False | ( (lv_isTrue_2_0= True ) ) ) )
            // InternalUSFLanguageParser.g:1061:3: () (otherlv_1= False | ( (lv_isTrue_2_0= True ) ) )
            {
            // InternalUSFLanguageParser.g:1061:3: ()
            // InternalUSFLanguageParser.g:1062:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getBooleanLiteralAccess().getBooleanLiteralAction_0(),
              					current);
              			
            }

            }

            // InternalUSFLanguageParser.g:1068:3: (otherlv_1= False | ( (lv_isTrue_2_0= True ) ) )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==False) ) {
                alt12=1;
            }
            else if ( (LA12_0==True) ) {
                alt12=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // InternalUSFLanguageParser.g:1069:4: otherlv_1= False
                    {
                    otherlv_1=(Token)match(input,False,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getBooleanLiteralAccess().getFalseKeyword_1_0());
                      			
                    }

                    }
                    break;
                case 2 :
                    // InternalUSFLanguageParser.g:1074:4: ( (lv_isTrue_2_0= True ) )
                    {
                    // InternalUSFLanguageParser.g:1074:4: ( (lv_isTrue_2_0= True ) )
                    // InternalUSFLanguageParser.g:1075:5: (lv_isTrue_2_0= True )
                    {
                    // InternalUSFLanguageParser.g:1075:5: (lv_isTrue_2_0= True )
                    // InternalUSFLanguageParser.g:1076:6: lv_isTrue_2_0= True
                    {
                    lv_isTrue_2_0=(Token)match(input,True,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_isTrue_2_0, grammarAccess.getBooleanLiteralAccess().getIsTrueTrueKeyword_1_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getBooleanLiteralRule());
                      						}
                      						setWithLastConsumed(current, "isTrue", lv_isTrue_2_0 != null, "true");
                      					
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBooleanLiteral"


    // $ANTLR start "entryRulePortDirectionLiteral"
    // InternalUSFLanguageParser.g:1093:1: entryRulePortDirectionLiteral returns [EObject current=null] : iv_rulePortDirectionLiteral= rulePortDirectionLiteral EOF ;
    public final EObject entryRulePortDirectionLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePortDirectionLiteral = null;


        try {
            // InternalUSFLanguageParser.g:1093:61: (iv_rulePortDirectionLiteral= rulePortDirectionLiteral EOF )
            // InternalUSFLanguageParser.g:1094:2: iv_rulePortDirectionLiteral= rulePortDirectionLiteral EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPortDirectionLiteralRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_rulePortDirectionLiteral=rulePortDirectionLiteral();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePortDirectionLiteral; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePortDirectionLiteral"


    // $ANTLR start "rulePortDirectionLiteral"
    // InternalUSFLanguageParser.g:1100:1: rulePortDirectionLiteral returns [EObject current=null] : ( () ( (lv_direction_1_0= rulePortDirection ) ) ) ;
    public final EObject rulePortDirectionLiteral() throws RecognitionException {
        EObject current = null;

        Enumerator lv_direction_1_0 = null;



        	enterRule();

        try {
            // InternalUSFLanguageParser.g:1106:2: ( ( () ( (lv_direction_1_0= rulePortDirection ) ) ) )
            // InternalUSFLanguageParser.g:1107:2: ( () ( (lv_direction_1_0= rulePortDirection ) ) )
            {
            // InternalUSFLanguageParser.g:1107:2: ( () ( (lv_direction_1_0= rulePortDirection ) ) )
            // InternalUSFLanguageParser.g:1108:3: () ( (lv_direction_1_0= rulePortDirection ) )
            {
            // InternalUSFLanguageParser.g:1108:3: ()
            // InternalUSFLanguageParser.g:1109:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getPortDirectionLiteralAccess().getPortDirectionLiteralAction_0(),
              					current);
              			
            }

            }

            // InternalUSFLanguageParser.g:1115:3: ( (lv_direction_1_0= rulePortDirection ) )
            // InternalUSFLanguageParser.g:1116:4: (lv_direction_1_0= rulePortDirection )
            {
            // InternalUSFLanguageParser.g:1116:4: (lv_direction_1_0= rulePortDirection )
            // InternalUSFLanguageParser.g:1117:5: lv_direction_1_0= rulePortDirection
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getPortDirectionLiteralAccess().getDirectionPortDirectionEnumRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_direction_1_0=rulePortDirection();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getPortDirectionLiteralRule());
              					}
              					set(
              						current,
              						"direction",
              						lv_direction_1_0,
              						"org.safe4i.usf.transformation.language.USFLanguage.PortDirection");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePortDirectionLiteral"


    // $ANTLR start "entryRuleNumber"
    // InternalUSFLanguageParser.g:1138:1: entryRuleNumber returns [String current=null] : iv_ruleNumber= ruleNumber EOF ;
    public final String entryRuleNumber() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleNumber = null;



        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalUSFLanguageParser.g:1140:2: (iv_ruleNumber= ruleNumber EOF )
            // InternalUSFLanguageParser.g:1141:2: iv_ruleNumber= ruleNumber EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getNumberRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleNumber=ruleNumber();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleNumber.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleNumber"


    // $ANTLR start "ruleNumber"
    // InternalUSFLanguageParser.g:1150:1: ruleNumber returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_INT_0= RULE_INT (kw= FullStop this_INT_2= RULE_INT )? ) ;
    public final AntlrDatatypeRuleToken ruleNumber() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;
        Token kw=null;
        Token this_INT_2=null;


        	enterRule();
        	HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();

        try {
            // InternalUSFLanguageParser.g:1157:2: ( (this_INT_0= RULE_INT (kw= FullStop this_INT_2= RULE_INT )? ) )
            // InternalUSFLanguageParser.g:1158:2: (this_INT_0= RULE_INT (kw= FullStop this_INT_2= RULE_INT )? )
            {
            // InternalUSFLanguageParser.g:1158:2: (this_INT_0= RULE_INT (kw= FullStop this_INT_2= RULE_INT )? )
            // InternalUSFLanguageParser.g:1159:3: this_INT_0= RULE_INT (kw= FullStop this_INT_2= RULE_INT )?
            {
            this_INT_0=(Token)match(input,RULE_INT,FOLLOW_24); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_INT_0);
              		
            }
            if ( state.backtracking==0 ) {

              			newLeafNode(this_INT_0, grammarAccess.getNumberAccess().getINTTerminalRuleCall_0());
              		
            }
            // InternalUSFLanguageParser.g:1166:3: (kw= FullStop this_INT_2= RULE_INT )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==FullStop) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalUSFLanguageParser.g:1167:4: kw= FullStop this_INT_2= RULE_INT
                    {
                    kw=(Token)match(input,FullStop,FOLLOW_25); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(kw);
                      				newLeafNode(kw, grammarAccess.getNumberAccess().getFullStopKeyword_1_0());
                      			
                    }
                    this_INT_2=(Token)match(input,RULE_INT,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current.merge(this_INT_2);
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_INT_2, grammarAccess.getNumberAccess().getINTTerminalRuleCall_1_1());
                      			
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleNumber"


    // $ANTLR start "entryRuleFeatureCallExpression"
    // InternalUSFLanguageParser.g:1187:1: entryRuleFeatureCallExpression returns [EObject current=null] : iv_ruleFeatureCallExpression= ruleFeatureCallExpression EOF ;
    public final EObject entryRuleFeatureCallExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFeatureCallExpression = null;


        try {
            // InternalUSFLanguageParser.g:1187:62: (iv_ruleFeatureCallExpression= ruleFeatureCallExpression EOF )
            // InternalUSFLanguageParser.g:1188:2: iv_ruleFeatureCallExpression= ruleFeatureCallExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFeatureCallExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleFeatureCallExpression=ruleFeatureCallExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFeatureCallExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleFeatureCallExpression"


    // $ANTLR start "ruleFeatureCallExpression"
    // InternalUSFLanguageParser.g:1194:1: ruleFeatureCallExpression returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= FullStop )+ ( (otherlv_2= RULE_ID ) ) (otherlv_3= LeftParenthesis ( ( (lv_parameterValues_4_0= ruleExpression ) ) (otherlv_5= Comma ( (lv_parameterValues_6_0= ruleExpression ) ) )* )? otherlv_7= RightParenthesis )? ) ;
    public final EObject ruleFeatureCallExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_parameterValues_4_0 = null;

        EObject lv_parameterValues_6_0 = null;



        	enterRule();

        try {
            // InternalUSFLanguageParser.g:1200:2: ( ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= FullStop )+ ( (otherlv_2= RULE_ID ) ) (otherlv_3= LeftParenthesis ( ( (lv_parameterValues_4_0= ruleExpression ) ) (otherlv_5= Comma ( (lv_parameterValues_6_0= ruleExpression ) ) )* )? otherlv_7= RightParenthesis )? ) )
            // InternalUSFLanguageParser.g:1201:2: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= FullStop )+ ( (otherlv_2= RULE_ID ) ) (otherlv_3= LeftParenthesis ( ( (lv_parameterValues_4_0= ruleExpression ) ) (otherlv_5= Comma ( (lv_parameterValues_6_0= ruleExpression ) ) )* )? otherlv_7= RightParenthesis )? )
            {
            // InternalUSFLanguageParser.g:1201:2: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= FullStop )+ ( (otherlv_2= RULE_ID ) ) (otherlv_3= LeftParenthesis ( ( (lv_parameterValues_4_0= ruleExpression ) ) (otherlv_5= Comma ( (lv_parameterValues_6_0= ruleExpression ) ) )* )? otherlv_7= RightParenthesis )? )
            // InternalUSFLanguageParser.g:1202:3: ( (otherlv_0= RULE_ID ) ) (otherlv_1= FullStop )+ ( (otherlv_2= RULE_ID ) ) (otherlv_3= LeftParenthesis ( ( (lv_parameterValues_4_0= ruleExpression ) ) (otherlv_5= Comma ( (lv_parameterValues_6_0= ruleExpression ) ) )* )? otherlv_7= RightParenthesis )?
            {
            // InternalUSFLanguageParser.g:1202:3: ( (otherlv_0= RULE_ID ) )
            // InternalUSFLanguageParser.g:1203:4: (otherlv_0= RULE_ID )
            {
            // InternalUSFLanguageParser.g:1203:4: (otherlv_0= RULE_ID )
            // InternalUSFLanguageParser.g:1204:5: otherlv_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getFeatureCallExpressionRule());
              					}
              				
            }
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_26); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_0, grammarAccess.getFeatureCallExpressionAccess().getContextTypedMemberCrossReference_0_0());
              				
            }

            }


            }

            // InternalUSFLanguageParser.g:1215:3: (otherlv_1= FullStop )+
            int cnt14=0;
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==FullStop) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalUSFLanguageParser.g:1216:4: otherlv_1= FullStop
            	    {
            	    otherlv_1=(Token)match(input,FullStop,FOLLOW_27); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_1, grammarAccess.getFeatureCallExpressionAccess().getFullStopKeyword_1());
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    if ( cnt14 >= 1 ) break loop14;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(14, input);
                        throw eee;
                }
                cnt14++;
            } while (true);

            // InternalUSFLanguageParser.g:1221:3: ( (otherlv_2= RULE_ID ) )
            // InternalUSFLanguageParser.g:1222:4: (otherlv_2= RULE_ID )
            {
            // InternalUSFLanguageParser.g:1222:4: (otherlv_2= RULE_ID )
            // InternalUSFLanguageParser.g:1223:5: otherlv_2= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getFeatureCallExpressionRule());
              					}
              				
            }
            otherlv_2=(Token)match(input,RULE_ID,FOLLOW_28); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_2, grammarAccess.getFeatureCallExpressionAccess().getStructuralFeatureETypedElementCrossReference_2_0());
              				
            }

            }


            }

            // InternalUSFLanguageParser.g:1234:3: (otherlv_3= LeftParenthesis ( ( (lv_parameterValues_4_0= ruleExpression ) ) (otherlv_5= Comma ( (lv_parameterValues_6_0= ruleExpression ) ) )* )? otherlv_7= RightParenthesis )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==LeftParenthesis) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalUSFLanguageParser.g:1235:4: otherlv_3= LeftParenthesis ( ( (lv_parameterValues_4_0= ruleExpression ) ) (otherlv_5= Comma ( (lv_parameterValues_6_0= ruleExpression ) ) )* )? otherlv_7= RightParenthesis
                    {
                    otherlv_3=(Token)match(input,LeftParenthesis,FOLLOW_29); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getFeatureCallExpressionAccess().getLeftParenthesisKeyword_3_0());
                      			
                    }
                    // InternalUSFLanguageParser.g:1239:4: ( ( (lv_parameterValues_4_0= ruleExpression ) ) (otherlv_5= Comma ( (lv_parameterValues_6_0= ruleExpression ) ) )* )?
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( ((LA16_0>=PortDirectionINOUT && LA16_0<=PortDirectionIN)||LA16_0==False||(LA16_0>=Null && LA16_0<=True)||(LA16_0>=For && LA16_0<=Var)||LA16_0==If||(LA16_0>=RULE_ID && LA16_0<=RULE_STRING)) ) {
                        alt16=1;
                    }
                    switch (alt16) {
                        case 1 :
                            // InternalUSFLanguageParser.g:1240:5: ( (lv_parameterValues_4_0= ruleExpression ) ) (otherlv_5= Comma ( (lv_parameterValues_6_0= ruleExpression ) ) )*
                            {
                            // InternalUSFLanguageParser.g:1240:5: ( (lv_parameterValues_4_0= ruleExpression ) )
                            // InternalUSFLanguageParser.g:1241:6: (lv_parameterValues_4_0= ruleExpression )
                            {
                            // InternalUSFLanguageParser.g:1241:6: (lv_parameterValues_4_0= ruleExpression )
                            // InternalUSFLanguageParser.g:1242:7: lv_parameterValues_4_0= ruleExpression
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getFeatureCallExpressionAccess().getParameterValuesExpressionParserRuleCall_3_1_0_0());
                              						
                            }
                            pushFollow(FOLLOW_7);
                            lv_parameterValues_4_0=ruleExpression();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getFeatureCallExpressionRule());
                              							}
                              							add(
                              								current,
                              								"parameterValues",
                              								lv_parameterValues_4_0,
                              								"org.safe4i.usf.transformation.language.USFLanguage.Expression");
                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }


                            }

                            // InternalUSFLanguageParser.g:1259:5: (otherlv_5= Comma ( (lv_parameterValues_6_0= ruleExpression ) ) )*
                            loop15:
                            do {
                                int alt15=2;
                                int LA15_0 = input.LA(1);

                                if ( (LA15_0==Comma) ) {
                                    alt15=1;
                                }


                                switch (alt15) {
                            	case 1 :
                            	    // InternalUSFLanguageParser.g:1260:6: otherlv_5= Comma ( (lv_parameterValues_6_0= ruleExpression ) )
                            	    {
                            	    otherlv_5=(Token)match(input,Comma,FOLLOW_16); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      						newLeafNode(otherlv_5, grammarAccess.getFeatureCallExpressionAccess().getCommaKeyword_3_1_1_0());
                            	      					
                            	    }
                            	    // InternalUSFLanguageParser.g:1264:6: ( (lv_parameterValues_6_0= ruleExpression ) )
                            	    // InternalUSFLanguageParser.g:1265:7: (lv_parameterValues_6_0= ruleExpression )
                            	    {
                            	    // InternalUSFLanguageParser.g:1265:7: (lv_parameterValues_6_0= ruleExpression )
                            	    // InternalUSFLanguageParser.g:1266:8: lv_parameterValues_6_0= ruleExpression
                            	    {
                            	    if ( state.backtracking==0 ) {

                            	      								newCompositeNode(grammarAccess.getFeatureCallExpressionAccess().getParameterValuesExpressionParserRuleCall_3_1_1_1_0());
                            	      							
                            	    }
                            	    pushFollow(FOLLOW_7);
                            	    lv_parameterValues_6_0=ruleExpression();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      								if (current==null) {
                            	      									current = createModelElementForParent(grammarAccess.getFeatureCallExpressionRule());
                            	      								}
                            	      								add(
                            	      									current,
                            	      									"parameterValues",
                            	      									lv_parameterValues_6_0,
                            	      									"org.safe4i.usf.transformation.language.USFLanguage.Expression");
                            	      								afterParserOrEnumRuleCall();
                            	      							
                            	    }

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop15;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_7=(Token)match(input,RightParenthesis,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_7, grammarAccess.getFeatureCallExpressionAccess().getRightParenthesisKeyword_3_2());
                      			
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleFeatureCallExpression"


    // $ANTLR start "entryRuleOperationCallExpression"
    // InternalUSFLanguageParser.g:1294:1: entryRuleOperationCallExpression returns [EObject current=null] : iv_ruleOperationCallExpression= ruleOperationCallExpression EOF ;
    public final EObject entryRuleOperationCallExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperationCallExpression = null;


        try {
            // InternalUSFLanguageParser.g:1294:64: (iv_ruleOperationCallExpression= ruleOperationCallExpression EOF )
            // InternalUSFLanguageParser.g:1295:2: iv_ruleOperationCallExpression= ruleOperationCallExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOperationCallExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOperationCallExpression=ruleOperationCallExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOperationCallExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOperationCallExpression"


    // $ANTLR start "ruleOperationCallExpression"
    // InternalUSFLanguageParser.g:1301:1: ruleOperationCallExpression returns [EObject current=null] : ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= LeftParenthesis ( ( (lv_parameterValues_3_0= ruleExpression ) ) (otherlv_4= Comma ( (lv_parameterValues_5_0= ruleExpression ) ) )* )? otherlv_6= RightParenthesis ) ;
    public final EObject ruleOperationCallExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_parameterValues_3_0 = null;

        EObject lv_parameterValues_5_0 = null;



        	enterRule();

        try {
            // InternalUSFLanguageParser.g:1307:2: ( ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= LeftParenthesis ( ( (lv_parameterValues_3_0= ruleExpression ) ) (otherlv_4= Comma ( (lv_parameterValues_5_0= ruleExpression ) ) )* )? otherlv_6= RightParenthesis ) )
            // InternalUSFLanguageParser.g:1308:2: ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= LeftParenthesis ( ( (lv_parameterValues_3_0= ruleExpression ) ) (otherlv_4= Comma ( (lv_parameterValues_5_0= ruleExpression ) ) )* )? otherlv_6= RightParenthesis )
            {
            // InternalUSFLanguageParser.g:1308:2: ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= LeftParenthesis ( ( (lv_parameterValues_3_0= ruleExpression ) ) (otherlv_4= Comma ( (lv_parameterValues_5_0= ruleExpression ) ) )* )? otherlv_6= RightParenthesis )
            // InternalUSFLanguageParser.g:1309:3: () ( (otherlv_1= RULE_ID ) ) otherlv_2= LeftParenthesis ( ( (lv_parameterValues_3_0= ruleExpression ) ) (otherlv_4= Comma ( (lv_parameterValues_5_0= ruleExpression ) ) )* )? otherlv_6= RightParenthesis
            {
            // InternalUSFLanguageParser.g:1309:3: ()
            // InternalUSFLanguageParser.g:1310:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getOperationCallExpressionAccess().getOperationCallExpressionAction_0(),
              					current);
              			
            }

            }

            // InternalUSFLanguageParser.g:1316:3: ( (otherlv_1= RULE_ID ) )
            // InternalUSFLanguageParser.g:1317:4: (otherlv_1= RULE_ID )
            {
            // InternalUSFLanguageParser.g:1317:4: (otherlv_1= RULE_ID )
            // InternalUSFLanguageParser.g:1318:5: otherlv_1= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getOperationCallExpressionRule());
              					}
              				
            }
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_1, grammarAccess.getOperationCallExpressionAccess().getOperationEOperationCrossReference_1_0());
              				
            }

            }


            }

            otherlv_2=(Token)match(input,LeftParenthesis,FOLLOW_29); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getOperationCallExpressionAccess().getLeftParenthesisKeyword_2());
              		
            }
            // InternalUSFLanguageParser.g:1333:3: ( ( (lv_parameterValues_3_0= ruleExpression ) ) (otherlv_4= Comma ( (lv_parameterValues_5_0= ruleExpression ) ) )* )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( ((LA19_0>=PortDirectionINOUT && LA19_0<=PortDirectionIN)||LA19_0==False||(LA19_0>=Null && LA19_0<=True)||(LA19_0>=For && LA19_0<=Var)||LA19_0==If||(LA19_0>=RULE_ID && LA19_0<=RULE_STRING)) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalUSFLanguageParser.g:1334:4: ( (lv_parameterValues_3_0= ruleExpression ) ) (otherlv_4= Comma ( (lv_parameterValues_5_0= ruleExpression ) ) )*
                    {
                    // InternalUSFLanguageParser.g:1334:4: ( (lv_parameterValues_3_0= ruleExpression ) )
                    // InternalUSFLanguageParser.g:1335:5: (lv_parameterValues_3_0= ruleExpression )
                    {
                    // InternalUSFLanguageParser.g:1335:5: (lv_parameterValues_3_0= ruleExpression )
                    // InternalUSFLanguageParser.g:1336:6: lv_parameterValues_3_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getOperationCallExpressionAccess().getParameterValuesExpressionParserRuleCall_3_0_0());
                      					
                    }
                    pushFollow(FOLLOW_7);
                    lv_parameterValues_3_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getOperationCallExpressionRule());
                      						}
                      						add(
                      							current,
                      							"parameterValues",
                      							lv_parameterValues_3_0,
                      							"org.safe4i.usf.transformation.language.USFLanguage.Expression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalUSFLanguageParser.g:1353:4: (otherlv_4= Comma ( (lv_parameterValues_5_0= ruleExpression ) ) )*
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( (LA18_0==Comma) ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // InternalUSFLanguageParser.g:1354:5: otherlv_4= Comma ( (lv_parameterValues_5_0= ruleExpression ) )
                    	    {
                    	    otherlv_4=(Token)match(input,Comma,FOLLOW_16); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_4, grammarAccess.getOperationCallExpressionAccess().getCommaKeyword_3_1_0());
                    	      				
                    	    }
                    	    // InternalUSFLanguageParser.g:1358:5: ( (lv_parameterValues_5_0= ruleExpression ) )
                    	    // InternalUSFLanguageParser.g:1359:6: (lv_parameterValues_5_0= ruleExpression )
                    	    {
                    	    // InternalUSFLanguageParser.g:1359:6: (lv_parameterValues_5_0= ruleExpression )
                    	    // InternalUSFLanguageParser.g:1360:7: lv_parameterValues_5_0= ruleExpression
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getOperationCallExpressionAccess().getParameterValuesExpressionParserRuleCall_3_1_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_7);
                    	    lv_parameterValues_5_0=ruleExpression();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getOperationCallExpressionRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"parameterValues",
                    	      								lv_parameterValues_5_0,
                    	      								"org.safe4i.usf.transformation.language.USFLanguage.Expression");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop18;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_6=(Token)match(input,RightParenthesis,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getOperationCallExpressionAccess().getRightParenthesisKeyword_4());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOperationCallExpression"


    // $ANTLR start "entryRuleAssignmentOrVariableDeclaration"
    // InternalUSFLanguageParser.g:1387:1: entryRuleAssignmentOrVariableDeclaration returns [EObject current=null] : iv_ruleAssignmentOrVariableDeclaration= ruleAssignmentOrVariableDeclaration EOF ;
    public final EObject entryRuleAssignmentOrVariableDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignmentOrVariableDeclaration = null;


        try {
            // InternalUSFLanguageParser.g:1387:72: (iv_ruleAssignmentOrVariableDeclaration= ruleAssignmentOrVariableDeclaration EOF )
            // InternalUSFLanguageParser.g:1388:2: iv_ruleAssignmentOrVariableDeclaration= ruleAssignmentOrVariableDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAssignmentOrVariableDeclarationRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAssignmentOrVariableDeclaration=ruleAssignmentOrVariableDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAssignmentOrVariableDeclaration; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAssignmentOrVariableDeclaration"


    // $ANTLR start "ruleAssignmentOrVariableDeclaration"
    // InternalUSFLanguageParser.g:1394:1: ruleAssignmentOrVariableDeclaration returns [EObject current=null] : (this_VariableDeclaration_0= ruleVariableDeclaration | this_AssignmentExpression_1= ruleAssignmentExpression ) ;
    public final EObject ruleAssignmentOrVariableDeclaration() throws RecognitionException {
        EObject current = null;

        EObject this_VariableDeclaration_0 = null;

        EObject this_AssignmentExpression_1 = null;



        	enterRule();

        try {
            // InternalUSFLanguageParser.g:1400:2: ( (this_VariableDeclaration_0= ruleVariableDeclaration | this_AssignmentExpression_1= ruleAssignmentExpression ) )
            // InternalUSFLanguageParser.g:1401:2: (this_VariableDeclaration_0= ruleVariableDeclaration | this_AssignmentExpression_1= ruleAssignmentExpression )
            {
            // InternalUSFLanguageParser.g:1401:2: (this_VariableDeclaration_0= ruleVariableDeclaration | this_AssignmentExpression_1= ruleAssignmentExpression )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( ((LA20_0>=Val && LA20_0<=Var)) ) {
                alt20=1;
            }
            else if ( (LA20_0==RULE_ID) ) {
                alt20=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // InternalUSFLanguageParser.g:1402:3: this_VariableDeclaration_0= ruleVariableDeclaration
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getAssignmentOrVariableDeclarationAccess().getVariableDeclarationParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_VariableDeclaration_0=ruleVariableDeclaration();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_VariableDeclaration_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalUSFLanguageParser.g:1411:3: this_AssignmentExpression_1= ruleAssignmentExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getAssignmentOrVariableDeclarationAccess().getAssignmentExpressionParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_AssignmentExpression_1=ruleAssignmentExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_AssignmentExpression_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAssignmentOrVariableDeclaration"


    // $ANTLR start "entryRuleVariableDeclaration"
    // InternalUSFLanguageParser.g:1423:1: entryRuleVariableDeclaration returns [EObject current=null] : iv_ruleVariableDeclaration= ruleVariableDeclaration EOF ;
    public final EObject entryRuleVariableDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableDeclaration = null;


        try {
            // InternalUSFLanguageParser.g:1423:60: (iv_ruleVariableDeclaration= ruleVariableDeclaration EOF )
            // InternalUSFLanguageParser.g:1424:2: iv_ruleVariableDeclaration= ruleVariableDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVariableDeclarationRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleVariableDeclaration=ruleVariableDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVariableDeclaration; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleVariableDeclaration"


    // $ANTLR start "ruleVariableDeclaration"
    // InternalUSFLanguageParser.g:1430:1: ruleVariableDeclaration returns [EObject current=null] : ( () ( ( (lv_writeable_1_0= Var ) ) | otherlv_2= Val ) ( ( ( ( ( ( ruleTransformationType ) ) ( ( RULE_ID ) ) ) )=> ( ( (lv_type_3_0= ruleTransformationType ) ) ( (lv_name_4_0= RULE_ID ) ) ) ) | ( (lv_name_5_0= RULE_ID ) ) ) (otherlv_6= EqualsSign ( (lv_rhs_7_0= ruleExpression ) ) )? ) ;
    public final EObject ruleVariableDeclaration() throws RecognitionException {
        EObject current = null;

        Token lv_writeable_1_0=null;
        Token otherlv_2=null;
        Token lv_name_4_0=null;
        Token lv_name_5_0=null;
        Token otherlv_6=null;
        EObject lv_type_3_0 = null;

        EObject lv_rhs_7_0 = null;



        	enterRule();

        try {
            // InternalUSFLanguageParser.g:1436:2: ( ( () ( ( (lv_writeable_1_0= Var ) ) | otherlv_2= Val ) ( ( ( ( ( ( ruleTransformationType ) ) ( ( RULE_ID ) ) ) )=> ( ( (lv_type_3_0= ruleTransformationType ) ) ( (lv_name_4_0= RULE_ID ) ) ) ) | ( (lv_name_5_0= RULE_ID ) ) ) (otherlv_6= EqualsSign ( (lv_rhs_7_0= ruleExpression ) ) )? ) )
            // InternalUSFLanguageParser.g:1437:2: ( () ( ( (lv_writeable_1_0= Var ) ) | otherlv_2= Val ) ( ( ( ( ( ( ruleTransformationType ) ) ( ( RULE_ID ) ) ) )=> ( ( (lv_type_3_0= ruleTransformationType ) ) ( (lv_name_4_0= RULE_ID ) ) ) ) | ( (lv_name_5_0= RULE_ID ) ) ) (otherlv_6= EqualsSign ( (lv_rhs_7_0= ruleExpression ) ) )? )
            {
            // InternalUSFLanguageParser.g:1437:2: ( () ( ( (lv_writeable_1_0= Var ) ) | otherlv_2= Val ) ( ( ( ( ( ( ruleTransformationType ) ) ( ( RULE_ID ) ) ) )=> ( ( (lv_type_3_0= ruleTransformationType ) ) ( (lv_name_4_0= RULE_ID ) ) ) ) | ( (lv_name_5_0= RULE_ID ) ) ) (otherlv_6= EqualsSign ( (lv_rhs_7_0= ruleExpression ) ) )? )
            // InternalUSFLanguageParser.g:1438:3: () ( ( (lv_writeable_1_0= Var ) ) | otherlv_2= Val ) ( ( ( ( ( ( ruleTransformationType ) ) ( ( RULE_ID ) ) ) )=> ( ( (lv_type_3_0= ruleTransformationType ) ) ( (lv_name_4_0= RULE_ID ) ) ) ) | ( (lv_name_5_0= RULE_ID ) ) ) (otherlv_6= EqualsSign ( (lv_rhs_7_0= ruleExpression ) ) )?
            {
            // InternalUSFLanguageParser.g:1438:3: ()
            // InternalUSFLanguageParser.g:1439:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getVariableDeclarationAccess().getVariableDeclarationAction_0(),
              					current);
              			
            }

            }

            // InternalUSFLanguageParser.g:1445:3: ( ( (lv_writeable_1_0= Var ) ) | otherlv_2= Val )
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==Var) ) {
                alt21=1;
            }
            else if ( (LA21_0==Val) ) {
                alt21=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }
            switch (alt21) {
                case 1 :
                    // InternalUSFLanguageParser.g:1446:4: ( (lv_writeable_1_0= Var ) )
                    {
                    // InternalUSFLanguageParser.g:1446:4: ( (lv_writeable_1_0= Var ) )
                    // InternalUSFLanguageParser.g:1447:5: (lv_writeable_1_0= Var )
                    {
                    // InternalUSFLanguageParser.g:1447:5: (lv_writeable_1_0= Var )
                    // InternalUSFLanguageParser.g:1448:6: lv_writeable_1_0= Var
                    {
                    lv_writeable_1_0=(Token)match(input,Var,FOLLOW_9); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_writeable_1_0, grammarAccess.getVariableDeclarationAccess().getWriteableVarKeyword_1_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getVariableDeclarationRule());
                      						}
                      						setWithLastConsumed(current, "writeable", lv_writeable_1_0 != null, "var");
                      					
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalUSFLanguageParser.g:1461:4: otherlv_2= Val
                    {
                    otherlv_2=(Token)match(input,Val,FOLLOW_9); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getVariableDeclarationAccess().getValKeyword_1_1());
                      			
                    }

                    }
                    break;

            }

            // InternalUSFLanguageParser.g:1466:3: ( ( ( ( ( ( ruleTransformationType ) ) ( ( RULE_ID ) ) ) )=> ( ( (lv_type_3_0= ruleTransformationType ) ) ( (lv_name_4_0= RULE_ID ) ) ) ) | ( (lv_name_5_0= RULE_ID ) ) )
            int alt22=2;
            alt22 = dfa22.predict(input);
            switch (alt22) {
                case 1 :
                    // InternalUSFLanguageParser.g:1467:4: ( ( ( ( ( ruleTransformationType ) ) ( ( RULE_ID ) ) ) )=> ( ( (lv_type_3_0= ruleTransformationType ) ) ( (lv_name_4_0= RULE_ID ) ) ) )
                    {
                    // InternalUSFLanguageParser.g:1467:4: ( ( ( ( ( ruleTransformationType ) ) ( ( RULE_ID ) ) ) )=> ( ( (lv_type_3_0= ruleTransformationType ) ) ( (lv_name_4_0= RULE_ID ) ) ) )
                    // InternalUSFLanguageParser.g:1468:5: ( ( ( ( ruleTransformationType ) ) ( ( RULE_ID ) ) ) )=> ( ( (lv_type_3_0= ruleTransformationType ) ) ( (lv_name_4_0= RULE_ID ) ) )
                    {
                    // InternalUSFLanguageParser.g:1481:5: ( ( (lv_type_3_0= ruleTransformationType ) ) ( (lv_name_4_0= RULE_ID ) ) )
                    // InternalUSFLanguageParser.g:1482:6: ( (lv_type_3_0= ruleTransformationType ) ) ( (lv_name_4_0= RULE_ID ) )
                    {
                    // InternalUSFLanguageParser.g:1482:6: ( (lv_type_3_0= ruleTransformationType ) )
                    // InternalUSFLanguageParser.g:1483:7: (lv_type_3_0= ruleTransformationType )
                    {
                    // InternalUSFLanguageParser.g:1483:7: (lv_type_3_0= ruleTransformationType )
                    // InternalUSFLanguageParser.g:1484:8: lv_type_3_0= ruleTransformationType
                    {
                    if ( state.backtracking==0 ) {

                      								newCompositeNode(grammarAccess.getVariableDeclarationAccess().getTypeTransformationTypeParserRuleCall_2_0_0_0_0());
                      							
                    }
                    pushFollow(FOLLOW_3);
                    lv_type_3_0=ruleTransformationType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      								if (current==null) {
                      									current = createModelElementForParent(grammarAccess.getVariableDeclarationRule());
                      								}
                      								set(
                      									current,
                      									"type",
                      									lv_type_3_0,
                      									"org.safe4i.usf.transformation.language.USFLanguage.TransformationType");
                      								afterParserOrEnumRuleCall();
                      							
                    }

                    }


                    }

                    // InternalUSFLanguageParser.g:1501:6: ( (lv_name_4_0= RULE_ID ) )
                    // InternalUSFLanguageParser.g:1502:7: (lv_name_4_0= RULE_ID )
                    {
                    // InternalUSFLanguageParser.g:1502:7: (lv_name_4_0= RULE_ID )
                    // InternalUSFLanguageParser.g:1503:8: lv_name_4_0= RULE_ID
                    {
                    lv_name_4_0=(Token)match(input,RULE_ID,FOLLOW_30); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      								newLeafNode(lv_name_4_0, grammarAccess.getVariableDeclarationAccess().getNameIDTerminalRuleCall_2_0_0_1_0());
                      							
                    }
                    if ( state.backtracking==0 ) {

                      								if (current==null) {
                      									current = createModelElement(grammarAccess.getVariableDeclarationRule());
                      								}
                      								setWithLastConsumed(
                      									current,
                      									"name",
                      									lv_name_4_0,
                      									"org.eclipse.xtext.common.Terminals.ID");
                      							
                    }

                    }


                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalUSFLanguageParser.g:1522:4: ( (lv_name_5_0= RULE_ID ) )
                    {
                    // InternalUSFLanguageParser.g:1522:4: ( (lv_name_5_0= RULE_ID ) )
                    // InternalUSFLanguageParser.g:1523:5: (lv_name_5_0= RULE_ID )
                    {
                    // InternalUSFLanguageParser.g:1523:5: (lv_name_5_0= RULE_ID )
                    // InternalUSFLanguageParser.g:1524:6: lv_name_5_0= RULE_ID
                    {
                    lv_name_5_0=(Token)match(input,RULE_ID,FOLLOW_30); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_name_5_0, grammarAccess.getVariableDeclarationAccess().getNameIDTerminalRuleCall_2_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getVariableDeclarationRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"name",
                      							lv_name_5_0,
                      							"org.eclipse.xtext.common.Terminals.ID");
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalUSFLanguageParser.g:1541:3: (otherlv_6= EqualsSign ( (lv_rhs_7_0= ruleExpression ) ) )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==EqualsSign) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // InternalUSFLanguageParser.g:1542:4: otherlv_6= EqualsSign ( (lv_rhs_7_0= ruleExpression ) )
                    {
                    otherlv_6=(Token)match(input,EqualsSign,FOLLOW_16); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_6, grammarAccess.getVariableDeclarationAccess().getEqualsSignKeyword_3_0());
                      			
                    }
                    // InternalUSFLanguageParser.g:1546:4: ( (lv_rhs_7_0= ruleExpression ) )
                    // InternalUSFLanguageParser.g:1547:5: (lv_rhs_7_0= ruleExpression )
                    {
                    // InternalUSFLanguageParser.g:1547:5: (lv_rhs_7_0= ruleExpression )
                    // InternalUSFLanguageParser.g:1548:6: lv_rhs_7_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getVariableDeclarationAccess().getRhsExpressionParserRuleCall_3_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_rhs_7_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getVariableDeclarationRule());
                      						}
                      						set(
                      							current,
                      							"rhs",
                      							lv_rhs_7_0,
                      							"org.safe4i.usf.transformation.language.USFLanguage.Expression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleVariableDeclaration"


    // $ANTLR start "entryRuleAssignmentExpression"
    // InternalUSFLanguageParser.g:1570:1: entryRuleAssignmentExpression returns [EObject current=null] : iv_ruleAssignmentExpression= ruleAssignmentExpression EOF ;
    public final EObject entryRuleAssignmentExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignmentExpression = null;


        try {
            // InternalUSFLanguageParser.g:1570:61: (iv_ruleAssignmentExpression= ruleAssignmentExpression EOF )
            // InternalUSFLanguageParser.g:1571:2: iv_ruleAssignmentExpression= ruleAssignmentExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAssignmentExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAssignmentExpression=ruleAssignmentExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAssignmentExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAssignmentExpression"


    // $ANTLR start "ruleAssignmentExpression"
    // InternalUSFLanguageParser.g:1577:1: ruleAssignmentExpression returns [EObject current=null] : ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= EqualsSign ( (lv_value_3_0= ruleExpression ) ) ) ;
    public final EObject ruleAssignmentExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_value_3_0 = null;



        	enterRule();

        try {
            // InternalUSFLanguageParser.g:1583:2: ( ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= EqualsSign ( (lv_value_3_0= ruleExpression ) ) ) )
            // InternalUSFLanguageParser.g:1584:2: ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= EqualsSign ( (lv_value_3_0= ruleExpression ) ) )
            {
            // InternalUSFLanguageParser.g:1584:2: ( () ( (otherlv_1= RULE_ID ) ) otherlv_2= EqualsSign ( (lv_value_3_0= ruleExpression ) ) )
            // InternalUSFLanguageParser.g:1585:3: () ( (otherlv_1= RULE_ID ) ) otherlv_2= EqualsSign ( (lv_value_3_0= ruleExpression ) )
            {
            // InternalUSFLanguageParser.g:1585:3: ()
            // InternalUSFLanguageParser.g:1586:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getAssignmentExpressionAccess().getAssignmentExpressionAction_0(),
              					current);
              			
            }

            }

            // InternalUSFLanguageParser.g:1592:3: ( (otherlv_1= RULE_ID ) )
            // InternalUSFLanguageParser.g:1593:4: (otherlv_1= RULE_ID )
            {
            // InternalUSFLanguageParser.g:1593:4: (otherlv_1= RULE_ID )
            // InternalUSFLanguageParser.g:1594:5: otherlv_1= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getAssignmentExpressionRule());
              					}
              				
            }
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_31); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_1, grammarAccess.getAssignmentExpressionAccess().getTypeMemberVariableDeclarationCrossReference_1_0());
              				
            }

            }


            }

            otherlv_2=(Token)match(input,EqualsSign,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getAssignmentExpressionAccess().getEqualsSignKeyword_2());
              		
            }
            // InternalUSFLanguageParser.g:1609:3: ( (lv_value_3_0= ruleExpression ) )
            // InternalUSFLanguageParser.g:1610:4: (lv_value_3_0= ruleExpression )
            {
            // InternalUSFLanguageParser.g:1610:4: (lv_value_3_0= ruleExpression )
            // InternalUSFLanguageParser.g:1611:5: lv_value_3_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getAssignmentExpressionAccess().getValueExpressionParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_value_3_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getAssignmentExpressionRule());
              					}
              					set(
              						current,
              						"value",
              						lv_value_3_0,
              						"org.safe4i.usf.transformation.language.USFLanguage.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAssignmentExpression"


    // $ANTLR start "entryRuleTypedMemberCallExpression"
    // InternalUSFLanguageParser.g:1632:1: entryRuleTypedMemberCallExpression returns [EObject current=null] : iv_ruleTypedMemberCallExpression= ruleTypedMemberCallExpression EOF ;
    public final EObject entryRuleTypedMemberCallExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypedMemberCallExpression = null;


        try {
            // InternalUSFLanguageParser.g:1632:66: (iv_ruleTypedMemberCallExpression= ruleTypedMemberCallExpression EOF )
            // InternalUSFLanguageParser.g:1633:2: iv_ruleTypedMemberCallExpression= ruleTypedMemberCallExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypedMemberCallExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleTypedMemberCallExpression=ruleTypedMemberCallExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypedMemberCallExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTypedMemberCallExpression"


    // $ANTLR start "ruleTypedMemberCallExpression"
    // InternalUSFLanguageParser.g:1639:1: ruleTypedMemberCallExpression returns [EObject current=null] : ( () ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleTypedMemberCallExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalUSFLanguageParser.g:1645:2: ( ( () ( (otherlv_1= RULE_ID ) ) ) )
            // InternalUSFLanguageParser.g:1646:2: ( () ( (otherlv_1= RULE_ID ) ) )
            {
            // InternalUSFLanguageParser.g:1646:2: ( () ( (otherlv_1= RULE_ID ) ) )
            // InternalUSFLanguageParser.g:1647:3: () ( (otherlv_1= RULE_ID ) )
            {
            // InternalUSFLanguageParser.g:1647:3: ()
            // InternalUSFLanguageParser.g:1648:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getTypedMemberCallExpressionAccess().getTypedMemberCallExpressionAction_0(),
              					current);
              			
            }

            }

            // InternalUSFLanguageParser.g:1654:3: ( (otherlv_1= RULE_ID ) )
            // InternalUSFLanguageParser.g:1655:4: (otherlv_1= RULE_ID )
            {
            // InternalUSFLanguageParser.g:1655:4: (otherlv_1= RULE_ID )
            // InternalUSFLanguageParser.g:1656:5: otherlv_1= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getTypedMemberCallExpressionRule());
              					}
              				
            }
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_1, grammarAccess.getTypedMemberCallExpressionAccess().getTypeMemberTypedMemberCrossReference_1_0());
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTypedMemberCallExpression"


    // $ANTLR start "entryRuleForLoopExpression"
    // InternalUSFLanguageParser.g:1671:1: entryRuleForLoopExpression returns [EObject current=null] : iv_ruleForLoopExpression= ruleForLoopExpression EOF ;
    public final EObject entryRuleForLoopExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleForLoopExpression = null;


        try {
            // InternalUSFLanguageParser.g:1671:58: (iv_ruleForLoopExpression= ruleForLoopExpression EOF )
            // InternalUSFLanguageParser.g:1672:2: iv_ruleForLoopExpression= ruleForLoopExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getForLoopExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleForLoopExpression=ruleForLoopExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleForLoopExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleForLoopExpression"


    // $ANTLR start "ruleForLoopExpression"
    // InternalUSFLanguageParser.g:1678:1: ruleForLoopExpression returns [EObject current=null] : ( ( ( ( () For LeftParenthesis ( ( ruleParameter ) ) In ) )=> ( () otherlv_1= For otherlv_2= LeftParenthesis ( (lv_declaredParam_3_0= ruleParameter ) ) otherlv_4= In ) ) ( (lv_forExpression_5_0= ruleExpression ) ) otherlv_6= RightParenthesis otherlv_7= LeftCurlyBracket (this_BEGIN_8= RULE_BEGIN ( (lv_eachExpression_9_0= ruleExpression ) )* this_END_10= RULE_END )? otherlv_11= RightCurlyBracket ) ;
    public final EObject ruleForLoopExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token this_BEGIN_8=null;
        Token this_END_10=null;
        Token otherlv_11=null;
        EObject lv_declaredParam_3_0 = null;

        EObject lv_forExpression_5_0 = null;

        EObject lv_eachExpression_9_0 = null;



        	enterRule();

        try {
            // InternalUSFLanguageParser.g:1684:2: ( ( ( ( ( () For LeftParenthesis ( ( ruleParameter ) ) In ) )=> ( () otherlv_1= For otherlv_2= LeftParenthesis ( (lv_declaredParam_3_0= ruleParameter ) ) otherlv_4= In ) ) ( (lv_forExpression_5_0= ruleExpression ) ) otherlv_6= RightParenthesis otherlv_7= LeftCurlyBracket (this_BEGIN_8= RULE_BEGIN ( (lv_eachExpression_9_0= ruleExpression ) )* this_END_10= RULE_END )? otherlv_11= RightCurlyBracket ) )
            // InternalUSFLanguageParser.g:1685:2: ( ( ( ( () For LeftParenthesis ( ( ruleParameter ) ) In ) )=> ( () otherlv_1= For otherlv_2= LeftParenthesis ( (lv_declaredParam_3_0= ruleParameter ) ) otherlv_4= In ) ) ( (lv_forExpression_5_0= ruleExpression ) ) otherlv_6= RightParenthesis otherlv_7= LeftCurlyBracket (this_BEGIN_8= RULE_BEGIN ( (lv_eachExpression_9_0= ruleExpression ) )* this_END_10= RULE_END )? otherlv_11= RightCurlyBracket )
            {
            // InternalUSFLanguageParser.g:1685:2: ( ( ( ( () For LeftParenthesis ( ( ruleParameter ) ) In ) )=> ( () otherlv_1= For otherlv_2= LeftParenthesis ( (lv_declaredParam_3_0= ruleParameter ) ) otherlv_4= In ) ) ( (lv_forExpression_5_0= ruleExpression ) ) otherlv_6= RightParenthesis otherlv_7= LeftCurlyBracket (this_BEGIN_8= RULE_BEGIN ( (lv_eachExpression_9_0= ruleExpression ) )* this_END_10= RULE_END )? otherlv_11= RightCurlyBracket )
            // InternalUSFLanguageParser.g:1686:3: ( ( ( () For LeftParenthesis ( ( ruleParameter ) ) In ) )=> ( () otherlv_1= For otherlv_2= LeftParenthesis ( (lv_declaredParam_3_0= ruleParameter ) ) otherlv_4= In ) ) ( (lv_forExpression_5_0= ruleExpression ) ) otherlv_6= RightParenthesis otherlv_7= LeftCurlyBracket (this_BEGIN_8= RULE_BEGIN ( (lv_eachExpression_9_0= ruleExpression ) )* this_END_10= RULE_END )? otherlv_11= RightCurlyBracket
            {
            // InternalUSFLanguageParser.g:1686:3: ( ( ( () For LeftParenthesis ( ( ruleParameter ) ) In ) )=> ( () otherlv_1= For otherlv_2= LeftParenthesis ( (lv_declaredParam_3_0= ruleParameter ) ) otherlv_4= In ) )
            // InternalUSFLanguageParser.g:1687:4: ( ( () For LeftParenthesis ( ( ruleParameter ) ) In ) )=> ( () otherlv_1= For otherlv_2= LeftParenthesis ( (lv_declaredParam_3_0= ruleParameter ) ) otherlv_4= In )
            {
            // InternalUSFLanguageParser.g:1700:4: ( () otherlv_1= For otherlv_2= LeftParenthesis ( (lv_declaredParam_3_0= ruleParameter ) ) otherlv_4= In )
            // InternalUSFLanguageParser.g:1701:5: () otherlv_1= For otherlv_2= LeftParenthesis ( (lv_declaredParam_3_0= ruleParameter ) ) otherlv_4= In
            {
            // InternalUSFLanguageParser.g:1701:5: ()
            // InternalUSFLanguageParser.g:1702:6: 
            {
            if ( state.backtracking==0 ) {

              						current = forceCreateModelElement(
              							grammarAccess.getForLoopExpressionAccess().getForLoopExpressionAction_0_0_0(),
              							current);
              					
            }

            }

            otherlv_1=(Token)match(input,For,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_1, grammarAccess.getForLoopExpressionAccess().getForKeyword_0_0_1());
              				
            }
            otherlv_2=(Token)match(input,LeftParenthesis,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_2, grammarAccess.getForLoopExpressionAccess().getLeftParenthesisKeyword_0_0_2());
              				
            }
            // InternalUSFLanguageParser.g:1716:5: ( (lv_declaredParam_3_0= ruleParameter ) )
            // InternalUSFLanguageParser.g:1717:6: (lv_declaredParam_3_0= ruleParameter )
            {
            // InternalUSFLanguageParser.g:1717:6: (lv_declaredParam_3_0= ruleParameter )
            // InternalUSFLanguageParser.g:1718:7: lv_declaredParam_3_0= ruleParameter
            {
            if ( state.backtracking==0 ) {

              							newCompositeNode(grammarAccess.getForLoopExpressionAccess().getDeclaredParamParameterParserRuleCall_0_0_3_0());
              						
            }
            pushFollow(FOLLOW_32);
            lv_declaredParam_3_0=ruleParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              							if (current==null) {
              								current = createModelElementForParent(grammarAccess.getForLoopExpressionRule());
              							}
              							set(
              								current,
              								"declaredParam",
              								lv_declaredParam_3_0,
              								"org.safe4i.usf.transformation.language.USFLanguage.Parameter");
              							afterParserOrEnumRuleCall();
              						
            }

            }


            }

            otherlv_4=(Token)match(input,In,FOLLOW_16); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_4, grammarAccess.getForLoopExpressionAccess().getInKeyword_0_0_4());
              				
            }

            }


            }

            // InternalUSFLanguageParser.g:1741:3: ( (lv_forExpression_5_0= ruleExpression ) )
            // InternalUSFLanguageParser.g:1742:4: (lv_forExpression_5_0= ruleExpression )
            {
            // InternalUSFLanguageParser.g:1742:4: (lv_forExpression_5_0= ruleExpression )
            // InternalUSFLanguageParser.g:1743:5: lv_forExpression_5_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getForLoopExpressionAccess().getForExpressionExpressionParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_33);
            lv_forExpression_5_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getForLoopExpressionRule());
              					}
              					set(
              						current,
              						"forExpression",
              						lv_forExpression_5_0,
              						"org.safe4i.usf.transformation.language.USFLanguage.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_6=(Token)match(input,RightParenthesis,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getForLoopExpressionAccess().getRightParenthesisKeyword_2());
              		
            }
            otherlv_7=(Token)match(input,LeftCurlyBracket,FOLLOW_34); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_7, grammarAccess.getForLoopExpressionAccess().getLeftCurlyBracketKeyword_3());
              		
            }
            // InternalUSFLanguageParser.g:1768:3: (this_BEGIN_8= RULE_BEGIN ( (lv_eachExpression_9_0= ruleExpression ) )* this_END_10= RULE_END )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==RULE_BEGIN) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalUSFLanguageParser.g:1769:4: this_BEGIN_8= RULE_BEGIN ( (lv_eachExpression_9_0= ruleExpression ) )* this_END_10= RULE_END
                    {
                    this_BEGIN_8=(Token)match(input,RULE_BEGIN,FOLLOW_13); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_BEGIN_8, grammarAccess.getForLoopExpressionAccess().getBEGINTerminalRuleCall_4_0());
                      			
                    }
                    // InternalUSFLanguageParser.g:1773:4: ( (lv_eachExpression_9_0= ruleExpression ) )*
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( ((LA24_0>=PortDirectionINOUT && LA24_0<=PortDirectionIN)||LA24_0==False||(LA24_0>=Null && LA24_0<=True)||(LA24_0>=For && LA24_0<=Var)||LA24_0==If||(LA24_0>=RULE_ID && LA24_0<=RULE_STRING)) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // InternalUSFLanguageParser.g:1774:5: (lv_eachExpression_9_0= ruleExpression )
                    	    {
                    	    // InternalUSFLanguageParser.g:1774:5: (lv_eachExpression_9_0= ruleExpression )
                    	    // InternalUSFLanguageParser.g:1775:6: lv_eachExpression_9_0= ruleExpression
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      						newCompositeNode(grammarAccess.getForLoopExpressionAccess().getEachExpressionExpressionParserRuleCall_4_1_0());
                    	      					
                    	    }
                    	    pushFollow(FOLLOW_13);
                    	    lv_eachExpression_9_0=ruleExpression();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						if (current==null) {
                    	      							current = createModelElementForParent(grammarAccess.getForLoopExpressionRule());
                    	      						}
                    	      						add(
                    	      							current,
                    	      							"eachExpression",
                    	      							lv_eachExpression_9_0,
                    	      							"org.safe4i.usf.transformation.language.USFLanguage.Expression");
                    	      						afterParserOrEnumRuleCall();
                    	      					
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop24;
                        }
                    } while (true);

                    this_END_10=(Token)match(input,RULE_END,FOLLOW_17); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_END_10, grammarAccess.getForLoopExpressionAccess().getENDTerminalRuleCall_4_2());
                      			
                    }

                    }
                    break;

            }

            otherlv_11=(Token)match(input,RightCurlyBracket,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_11, grammarAccess.getForLoopExpressionAccess().getRightCurlyBracketKeyword_5());
              		
            }

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleForLoopExpression"


    // $ANTLR start "entryRuleIfExpression"
    // InternalUSFLanguageParser.g:1805:1: entryRuleIfExpression returns [EObject current=null] : iv_ruleIfExpression= ruleIfExpression EOF ;
    public final EObject entryRuleIfExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfExpression = null;


        try {
            // InternalUSFLanguageParser.g:1805:53: (iv_ruleIfExpression= ruleIfExpression EOF )
            // InternalUSFLanguageParser.g:1806:2: iv_ruleIfExpression= ruleIfExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIfExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleIfExpression=ruleIfExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIfExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIfExpression"


    // $ANTLR start "ruleIfExpression"
    // InternalUSFLanguageParser.g:1812:1: ruleIfExpression returns [EObject current=null] : ( () otherlv_1= If otherlv_2= LeftParenthesis ( (lv_condition_3_0= ruleBooleanExpression ) ) otherlv_4= RightParenthesis otherlv_5= LeftCurlyBracket (this_BEGIN_6= RULE_BEGIN ( (lv_then_7_0= ruleExpression ) )* this_END_8= RULE_END )? otherlv_9= RightCurlyBracket ( ( ( Else )=>otherlv_10= Else ) otherlv_11= LeftCurlyBracket (this_BEGIN_12= RULE_BEGIN ( (lv_else_13_0= ruleExpression ) )* this_END_14= RULE_END )? otherlv_15= RightCurlyBracket )? ) ;
    public final EObject ruleIfExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token this_BEGIN_6=null;
        Token this_END_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token this_BEGIN_12=null;
        Token this_END_14=null;
        Token otherlv_15=null;
        EObject lv_condition_3_0 = null;

        EObject lv_then_7_0 = null;

        EObject lv_else_13_0 = null;



        	enterRule();

        try {
            // InternalUSFLanguageParser.g:1818:2: ( ( () otherlv_1= If otherlv_2= LeftParenthesis ( (lv_condition_3_0= ruleBooleanExpression ) ) otherlv_4= RightParenthesis otherlv_5= LeftCurlyBracket (this_BEGIN_6= RULE_BEGIN ( (lv_then_7_0= ruleExpression ) )* this_END_8= RULE_END )? otherlv_9= RightCurlyBracket ( ( ( Else )=>otherlv_10= Else ) otherlv_11= LeftCurlyBracket (this_BEGIN_12= RULE_BEGIN ( (lv_else_13_0= ruleExpression ) )* this_END_14= RULE_END )? otherlv_15= RightCurlyBracket )? ) )
            // InternalUSFLanguageParser.g:1819:2: ( () otherlv_1= If otherlv_2= LeftParenthesis ( (lv_condition_3_0= ruleBooleanExpression ) ) otherlv_4= RightParenthesis otherlv_5= LeftCurlyBracket (this_BEGIN_6= RULE_BEGIN ( (lv_then_7_0= ruleExpression ) )* this_END_8= RULE_END )? otherlv_9= RightCurlyBracket ( ( ( Else )=>otherlv_10= Else ) otherlv_11= LeftCurlyBracket (this_BEGIN_12= RULE_BEGIN ( (lv_else_13_0= ruleExpression ) )* this_END_14= RULE_END )? otherlv_15= RightCurlyBracket )? )
            {
            // InternalUSFLanguageParser.g:1819:2: ( () otherlv_1= If otherlv_2= LeftParenthesis ( (lv_condition_3_0= ruleBooleanExpression ) ) otherlv_4= RightParenthesis otherlv_5= LeftCurlyBracket (this_BEGIN_6= RULE_BEGIN ( (lv_then_7_0= ruleExpression ) )* this_END_8= RULE_END )? otherlv_9= RightCurlyBracket ( ( ( Else )=>otherlv_10= Else ) otherlv_11= LeftCurlyBracket (this_BEGIN_12= RULE_BEGIN ( (lv_else_13_0= ruleExpression ) )* this_END_14= RULE_END )? otherlv_15= RightCurlyBracket )? )
            // InternalUSFLanguageParser.g:1820:3: () otherlv_1= If otherlv_2= LeftParenthesis ( (lv_condition_3_0= ruleBooleanExpression ) ) otherlv_4= RightParenthesis otherlv_5= LeftCurlyBracket (this_BEGIN_6= RULE_BEGIN ( (lv_then_7_0= ruleExpression ) )* this_END_8= RULE_END )? otherlv_9= RightCurlyBracket ( ( ( Else )=>otherlv_10= Else ) otherlv_11= LeftCurlyBracket (this_BEGIN_12= RULE_BEGIN ( (lv_else_13_0= ruleExpression ) )* this_END_14= RULE_END )? otherlv_15= RightCurlyBracket )?
            {
            // InternalUSFLanguageParser.g:1820:3: ()
            // InternalUSFLanguageParser.g:1821:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getIfExpressionAccess().getIFExpressionAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,If,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getIfExpressionAccess().getIfKeyword_1());
              		
            }
            otherlv_2=(Token)match(input,LeftParenthesis,FOLLOW_35); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getIfExpressionAccess().getLeftParenthesisKeyword_2());
              		
            }
            // InternalUSFLanguageParser.g:1835:3: ( (lv_condition_3_0= ruleBooleanExpression ) )
            // InternalUSFLanguageParser.g:1836:4: (lv_condition_3_0= ruleBooleanExpression )
            {
            // InternalUSFLanguageParser.g:1836:4: (lv_condition_3_0= ruleBooleanExpression )
            // InternalUSFLanguageParser.g:1837:5: lv_condition_3_0= ruleBooleanExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getIfExpressionAccess().getConditionBooleanExpressionParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_33);
            lv_condition_3_0=ruleBooleanExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getIfExpressionRule());
              					}
              					set(
              						current,
              						"condition",
              						lv_condition_3_0,
              						"org.safe4i.usf.transformation.language.USFLanguage.BooleanExpression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_4=(Token)match(input,RightParenthesis,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getIfExpressionAccess().getRightParenthesisKeyword_4());
              		
            }
            otherlv_5=(Token)match(input,LeftCurlyBracket,FOLLOW_34); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getIfExpressionAccess().getLeftCurlyBracketKeyword_5());
              		
            }
            // InternalUSFLanguageParser.g:1862:3: (this_BEGIN_6= RULE_BEGIN ( (lv_then_7_0= ruleExpression ) )* this_END_8= RULE_END )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==RULE_BEGIN) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalUSFLanguageParser.g:1863:4: this_BEGIN_6= RULE_BEGIN ( (lv_then_7_0= ruleExpression ) )* this_END_8= RULE_END
                    {
                    this_BEGIN_6=(Token)match(input,RULE_BEGIN,FOLLOW_13); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_BEGIN_6, grammarAccess.getIfExpressionAccess().getBEGINTerminalRuleCall_6_0());
                      			
                    }
                    // InternalUSFLanguageParser.g:1867:4: ( (lv_then_7_0= ruleExpression ) )*
                    loop26:
                    do {
                        int alt26=2;
                        int LA26_0 = input.LA(1);

                        if ( ((LA26_0>=PortDirectionINOUT && LA26_0<=PortDirectionIN)||LA26_0==False||(LA26_0>=Null && LA26_0<=True)||(LA26_0>=For && LA26_0<=Var)||LA26_0==If||(LA26_0>=RULE_ID && LA26_0<=RULE_STRING)) ) {
                            alt26=1;
                        }


                        switch (alt26) {
                    	case 1 :
                    	    // InternalUSFLanguageParser.g:1868:5: (lv_then_7_0= ruleExpression )
                    	    {
                    	    // InternalUSFLanguageParser.g:1868:5: (lv_then_7_0= ruleExpression )
                    	    // InternalUSFLanguageParser.g:1869:6: lv_then_7_0= ruleExpression
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      						newCompositeNode(grammarAccess.getIfExpressionAccess().getThenExpressionParserRuleCall_6_1_0());
                    	      					
                    	    }
                    	    pushFollow(FOLLOW_13);
                    	    lv_then_7_0=ruleExpression();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      						if (current==null) {
                    	      							current = createModelElementForParent(grammarAccess.getIfExpressionRule());
                    	      						}
                    	      						add(
                    	      							current,
                    	      							"then",
                    	      							lv_then_7_0,
                    	      							"org.safe4i.usf.transformation.language.USFLanguage.Expression");
                    	      						afterParserOrEnumRuleCall();
                    	      					
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop26;
                        }
                    } while (true);

                    this_END_8=(Token)match(input,RULE_END,FOLLOW_17); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(this_END_8, grammarAccess.getIfExpressionAccess().getENDTerminalRuleCall_6_2());
                      			
                    }

                    }
                    break;

            }

            otherlv_9=(Token)match(input,RightCurlyBracket,FOLLOW_36); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_9, grammarAccess.getIfExpressionAccess().getRightCurlyBracketKeyword_7());
              		
            }
            // InternalUSFLanguageParser.g:1895:3: ( ( ( Else )=>otherlv_10= Else ) otherlv_11= LeftCurlyBracket (this_BEGIN_12= RULE_BEGIN ( (lv_else_13_0= ruleExpression ) )* this_END_14= RULE_END )? otherlv_15= RightCurlyBracket )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( (LA30_0==Else) && (synpred4_InternalUSFLanguageParser())) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalUSFLanguageParser.g:1896:4: ( ( Else )=>otherlv_10= Else ) otherlv_11= LeftCurlyBracket (this_BEGIN_12= RULE_BEGIN ( (lv_else_13_0= ruleExpression ) )* this_END_14= RULE_END )? otherlv_15= RightCurlyBracket
                    {
                    // InternalUSFLanguageParser.g:1896:4: ( ( Else )=>otherlv_10= Else )
                    // InternalUSFLanguageParser.g:1897:5: ( Else )=>otherlv_10= Else
                    {
                    otherlv_10=(Token)match(input,Else,FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_10, grammarAccess.getIfExpressionAccess().getElseKeyword_8_0());
                      				
                    }

                    }

                    otherlv_11=(Token)match(input,LeftCurlyBracket,FOLLOW_34); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_11, grammarAccess.getIfExpressionAccess().getLeftCurlyBracketKeyword_8_1());
                      			
                    }
                    // InternalUSFLanguageParser.g:1907:4: (this_BEGIN_12= RULE_BEGIN ( (lv_else_13_0= ruleExpression ) )* this_END_14= RULE_END )?
                    int alt29=2;
                    int LA29_0 = input.LA(1);

                    if ( (LA29_0==RULE_BEGIN) ) {
                        alt29=1;
                    }
                    switch (alt29) {
                        case 1 :
                            // InternalUSFLanguageParser.g:1908:5: this_BEGIN_12= RULE_BEGIN ( (lv_else_13_0= ruleExpression ) )* this_END_14= RULE_END
                            {
                            this_BEGIN_12=(Token)match(input,RULE_BEGIN,FOLLOW_13); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(this_BEGIN_12, grammarAccess.getIfExpressionAccess().getBEGINTerminalRuleCall_8_2_0());
                              				
                            }
                            // InternalUSFLanguageParser.g:1912:5: ( (lv_else_13_0= ruleExpression ) )*
                            loop28:
                            do {
                                int alt28=2;
                                int LA28_0 = input.LA(1);

                                if ( ((LA28_0>=PortDirectionINOUT && LA28_0<=PortDirectionIN)||LA28_0==False||(LA28_0>=Null && LA28_0<=True)||(LA28_0>=For && LA28_0<=Var)||LA28_0==If||(LA28_0>=RULE_ID && LA28_0<=RULE_STRING)) ) {
                                    alt28=1;
                                }


                                switch (alt28) {
                            	case 1 :
                            	    // InternalUSFLanguageParser.g:1913:6: (lv_else_13_0= ruleExpression )
                            	    {
                            	    // InternalUSFLanguageParser.g:1913:6: (lv_else_13_0= ruleExpression )
                            	    // InternalUSFLanguageParser.g:1914:7: lv_else_13_0= ruleExpression
                            	    {
                            	    if ( state.backtracking==0 ) {

                            	      							newCompositeNode(grammarAccess.getIfExpressionAccess().getElseExpressionParserRuleCall_8_2_1_0());
                            	      						
                            	    }
                            	    pushFollow(FOLLOW_13);
                            	    lv_else_13_0=ruleExpression();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      							if (current==null) {
                            	      								current = createModelElementForParent(grammarAccess.getIfExpressionRule());
                            	      							}
                            	      							add(
                            	      								current,
                            	      								"else",
                            	      								lv_else_13_0,
                            	      								"org.safe4i.usf.transformation.language.USFLanguage.Expression");
                            	      							afterParserOrEnumRuleCall();
                            	      						
                            	    }

                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop28;
                                }
                            } while (true);

                            this_END_14=(Token)match(input,RULE_END,FOLLOW_17); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(this_END_14, grammarAccess.getIfExpressionAccess().getENDTerminalRuleCall_8_2_2());
                              				
                            }

                            }
                            break;

                    }

                    otherlv_15=(Token)match(input,RightCurlyBracket,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_15, grammarAccess.getIfExpressionAccess().getRightCurlyBracketKeyword_8_3());
                      			
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIfExpression"


    // $ANTLR start "entryRuleBooleanExpression"
    // InternalUSFLanguageParser.g:1945:1: entryRuleBooleanExpression returns [EObject current=null] : iv_ruleBooleanExpression= ruleBooleanExpression EOF ;
    public final EObject entryRuleBooleanExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanExpression = null;


        try {
            // InternalUSFLanguageParser.g:1945:58: (iv_ruleBooleanExpression= ruleBooleanExpression EOF )
            // InternalUSFLanguageParser.g:1946:2: iv_ruleBooleanExpression= ruleBooleanExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBooleanExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBooleanExpression=ruleBooleanExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBooleanExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBooleanExpression"


    // $ANTLR start "ruleBooleanExpression"
    // InternalUSFLanguageParser.g:1952:1: ruleBooleanExpression returns [EObject current=null] : this_OrBooleanExpression_0= ruleOrBooleanExpression ;
    public final EObject ruleBooleanExpression() throws RecognitionException {
        EObject current = null;

        EObject this_OrBooleanExpression_0 = null;



        	enterRule();

        try {
            // InternalUSFLanguageParser.g:1958:2: (this_OrBooleanExpression_0= ruleOrBooleanExpression )
            // InternalUSFLanguageParser.g:1959:2: this_OrBooleanExpression_0= ruleOrBooleanExpression
            {
            if ( state.backtracking==0 ) {

              		newCompositeNode(grammarAccess.getBooleanExpressionAccess().getOrBooleanExpressionParserRuleCall());
              	
            }
            pushFollow(FOLLOW_2);
            this_OrBooleanExpression_0=ruleOrBooleanExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current = this_OrBooleanExpression_0;
              		afterParserOrEnumRuleCall();
              	
            }

            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBooleanExpression"


    // $ANTLR start "entryRuleOrBooleanExpression"
    // InternalUSFLanguageParser.g:1970:1: entryRuleOrBooleanExpression returns [EObject current=null] : iv_ruleOrBooleanExpression= ruleOrBooleanExpression EOF ;
    public final EObject entryRuleOrBooleanExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrBooleanExpression = null;


        try {
            // InternalUSFLanguageParser.g:1970:60: (iv_ruleOrBooleanExpression= ruleOrBooleanExpression EOF )
            // InternalUSFLanguageParser.g:1971:2: iv_ruleOrBooleanExpression= ruleOrBooleanExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOrBooleanExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOrBooleanExpression=ruleOrBooleanExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOrBooleanExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleOrBooleanExpression"


    // $ANTLR start "ruleOrBooleanExpression"
    // InternalUSFLanguageParser.g:1977:1: ruleOrBooleanExpression returns [EObject current=null] : (this_AndBooleanExpression_0= ruleAndBooleanExpression ( ( () otherlv_2= VerticalLineVerticalLine ) ( (lv_right_3_0= ruleAndBooleanExpression ) ) )* ) ;
    public final EObject ruleOrBooleanExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_AndBooleanExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalUSFLanguageParser.g:1983:2: ( (this_AndBooleanExpression_0= ruleAndBooleanExpression ( ( () otherlv_2= VerticalLineVerticalLine ) ( (lv_right_3_0= ruleAndBooleanExpression ) ) )* ) )
            // InternalUSFLanguageParser.g:1984:2: (this_AndBooleanExpression_0= ruleAndBooleanExpression ( ( () otherlv_2= VerticalLineVerticalLine ) ( (lv_right_3_0= ruleAndBooleanExpression ) ) )* )
            {
            // InternalUSFLanguageParser.g:1984:2: (this_AndBooleanExpression_0= ruleAndBooleanExpression ( ( () otherlv_2= VerticalLineVerticalLine ) ( (lv_right_3_0= ruleAndBooleanExpression ) ) )* )
            // InternalUSFLanguageParser.g:1985:3: this_AndBooleanExpression_0= ruleAndBooleanExpression ( ( () otherlv_2= VerticalLineVerticalLine ) ( (lv_right_3_0= ruleAndBooleanExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getOrBooleanExpressionAccess().getAndBooleanExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_37);
            this_AndBooleanExpression_0=ruleAndBooleanExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_AndBooleanExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalUSFLanguageParser.g:1993:3: ( ( () otherlv_2= VerticalLineVerticalLine ) ( (lv_right_3_0= ruleAndBooleanExpression ) ) )*
            loop31:
            do {
                int alt31=2;
                int LA31_0 = input.LA(1);

                if ( (LA31_0==VerticalLineVerticalLine) ) {
                    alt31=1;
                }


                switch (alt31) {
            	case 1 :
            	    // InternalUSFLanguageParser.g:1994:4: ( () otherlv_2= VerticalLineVerticalLine ) ( (lv_right_3_0= ruleAndBooleanExpression ) )
            	    {
            	    // InternalUSFLanguageParser.g:1994:4: ( () otherlv_2= VerticalLineVerticalLine )
            	    // InternalUSFLanguageParser.g:1995:5: () otherlv_2= VerticalLineVerticalLine
            	    {
            	    // InternalUSFLanguageParser.g:1995:5: ()
            	    // InternalUSFLanguageParser.g:1996:6: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      						current = forceCreateModelElementAndSet(
            	      							grammarAccess.getOrBooleanExpressionAccess().getOrBooleanExpressionLeftAction_1_0_0(),
            	      							current);
            	      					
            	    }

            	    }

            	    otherlv_2=(Token)match(input,VerticalLineVerticalLine,FOLLOW_35); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_2, grammarAccess.getOrBooleanExpressionAccess().getVerticalLineVerticalLineKeyword_1_0_1());
            	      				
            	    }

            	    }

            	    // InternalUSFLanguageParser.g:2007:4: ( (lv_right_3_0= ruleAndBooleanExpression ) )
            	    // InternalUSFLanguageParser.g:2008:5: (lv_right_3_0= ruleAndBooleanExpression )
            	    {
            	    // InternalUSFLanguageParser.g:2008:5: (lv_right_3_0= ruleAndBooleanExpression )
            	    // InternalUSFLanguageParser.g:2009:6: lv_right_3_0= ruleAndBooleanExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getOrBooleanExpressionAccess().getRightAndBooleanExpressionParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_37);
            	    lv_right_3_0=ruleAndBooleanExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getOrBooleanExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"org.safe4i.usf.transformation.language.USFLanguage.AndBooleanExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop31;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleOrBooleanExpression"


    // $ANTLR start "entryRuleAndBooleanExpression"
    // InternalUSFLanguageParser.g:2031:1: entryRuleAndBooleanExpression returns [EObject current=null] : iv_ruleAndBooleanExpression= ruleAndBooleanExpression EOF ;
    public final EObject entryRuleAndBooleanExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndBooleanExpression = null;


        try {
            // InternalUSFLanguageParser.g:2031:61: (iv_ruleAndBooleanExpression= ruleAndBooleanExpression EOF )
            // InternalUSFLanguageParser.g:2032:2: iv_ruleAndBooleanExpression= ruleAndBooleanExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAndBooleanExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAndBooleanExpression=ruleAndBooleanExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAndBooleanExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAndBooleanExpression"


    // $ANTLR start "ruleAndBooleanExpression"
    // InternalUSFLanguageParser.g:2038:1: ruleAndBooleanExpression returns [EObject current=null] : (this_ComparisonBooleanExpression_0= ruleComparisonBooleanExpression ( ( () otherlv_2= AmpersandAmpersand ) ( (lv_right_3_0= ruleComparisonBooleanExpression ) ) )* ) ;
    public final EObject ruleAndBooleanExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        EObject this_ComparisonBooleanExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalUSFLanguageParser.g:2044:2: ( (this_ComparisonBooleanExpression_0= ruleComparisonBooleanExpression ( ( () otherlv_2= AmpersandAmpersand ) ( (lv_right_3_0= ruleComparisonBooleanExpression ) ) )* ) )
            // InternalUSFLanguageParser.g:2045:2: (this_ComparisonBooleanExpression_0= ruleComparisonBooleanExpression ( ( () otherlv_2= AmpersandAmpersand ) ( (lv_right_3_0= ruleComparisonBooleanExpression ) ) )* )
            {
            // InternalUSFLanguageParser.g:2045:2: (this_ComparisonBooleanExpression_0= ruleComparisonBooleanExpression ( ( () otherlv_2= AmpersandAmpersand ) ( (lv_right_3_0= ruleComparisonBooleanExpression ) ) )* )
            // InternalUSFLanguageParser.g:2046:3: this_ComparisonBooleanExpression_0= ruleComparisonBooleanExpression ( ( () otherlv_2= AmpersandAmpersand ) ( (lv_right_3_0= ruleComparisonBooleanExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getAndBooleanExpressionAccess().getComparisonBooleanExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_38);
            this_ComparisonBooleanExpression_0=ruleComparisonBooleanExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_ComparisonBooleanExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalUSFLanguageParser.g:2054:3: ( ( () otherlv_2= AmpersandAmpersand ) ( (lv_right_3_0= ruleComparisonBooleanExpression ) ) )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==AmpersandAmpersand) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // InternalUSFLanguageParser.g:2055:4: ( () otherlv_2= AmpersandAmpersand ) ( (lv_right_3_0= ruleComparisonBooleanExpression ) )
            	    {
            	    // InternalUSFLanguageParser.g:2055:4: ( () otherlv_2= AmpersandAmpersand )
            	    // InternalUSFLanguageParser.g:2056:5: () otherlv_2= AmpersandAmpersand
            	    {
            	    // InternalUSFLanguageParser.g:2056:5: ()
            	    // InternalUSFLanguageParser.g:2057:6: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      						current = forceCreateModelElementAndSet(
            	      							grammarAccess.getAndBooleanExpressionAccess().getAndBooleanExpressionLeftAction_1_0_0(),
            	      							current);
            	      					
            	    }

            	    }

            	    otherlv_2=(Token)match(input,AmpersandAmpersand,FOLLOW_35); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					newLeafNode(otherlv_2, grammarAccess.getAndBooleanExpressionAccess().getAmpersandAmpersandKeyword_1_0_1());
            	      				
            	    }

            	    }

            	    // InternalUSFLanguageParser.g:2068:4: ( (lv_right_3_0= ruleComparisonBooleanExpression ) )
            	    // InternalUSFLanguageParser.g:2069:5: (lv_right_3_0= ruleComparisonBooleanExpression )
            	    {
            	    // InternalUSFLanguageParser.g:2069:5: (lv_right_3_0= ruleComparisonBooleanExpression )
            	    // InternalUSFLanguageParser.g:2070:6: lv_right_3_0= ruleComparisonBooleanExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getAndBooleanExpressionAccess().getRightComparisonBooleanExpressionParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_38);
            	    lv_right_3_0=ruleComparisonBooleanExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getAndBooleanExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"org.safe4i.usf.transformation.language.USFLanguage.ComparisonBooleanExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop32;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAndBooleanExpression"


    // $ANTLR start "entryRuleComparisonBooleanExpression"
    // InternalUSFLanguageParser.g:2092:1: entryRuleComparisonBooleanExpression returns [EObject current=null] : iv_ruleComparisonBooleanExpression= ruleComparisonBooleanExpression EOF ;
    public final EObject entryRuleComparisonBooleanExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComparisonBooleanExpression = null;


        try {
            // InternalUSFLanguageParser.g:2092:68: (iv_ruleComparisonBooleanExpression= ruleComparisonBooleanExpression EOF )
            // InternalUSFLanguageParser.g:2093:2: iv_ruleComparisonBooleanExpression= ruleComparisonBooleanExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getComparisonBooleanExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleComparisonBooleanExpression=ruleComparisonBooleanExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleComparisonBooleanExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleComparisonBooleanExpression"


    // $ANTLR start "ruleComparisonBooleanExpression"
    // InternalUSFLanguageParser.g:2099:1: ruleComparisonBooleanExpression returns [EObject current=null] : (this_BooleanNegationExpression_0= ruleBooleanNegationExpression ( () ( ( (lv_operator_2_1= LessThanSign | lv_operator_2_2= LessThanSignEqualsSign | lv_operator_2_3= EqualsSignEqualsSign | lv_operator_2_4= GreaterThanSignEqualsSign | lv_operator_2_5= GreaterThanSign | lv_operator_2_6= ExclamationMarkEqualsSign ) ) ) ( (lv_right_3_0= ruleBooleanNegationExpression ) ) )* ) ;
    public final EObject ruleComparisonBooleanExpression() throws RecognitionException {
        EObject current = null;

        Token lv_operator_2_1=null;
        Token lv_operator_2_2=null;
        Token lv_operator_2_3=null;
        Token lv_operator_2_4=null;
        Token lv_operator_2_5=null;
        Token lv_operator_2_6=null;
        EObject this_BooleanNegationExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalUSFLanguageParser.g:2105:2: ( (this_BooleanNegationExpression_0= ruleBooleanNegationExpression ( () ( ( (lv_operator_2_1= LessThanSign | lv_operator_2_2= LessThanSignEqualsSign | lv_operator_2_3= EqualsSignEqualsSign | lv_operator_2_4= GreaterThanSignEqualsSign | lv_operator_2_5= GreaterThanSign | lv_operator_2_6= ExclamationMarkEqualsSign ) ) ) ( (lv_right_3_0= ruleBooleanNegationExpression ) ) )* ) )
            // InternalUSFLanguageParser.g:2106:2: (this_BooleanNegationExpression_0= ruleBooleanNegationExpression ( () ( ( (lv_operator_2_1= LessThanSign | lv_operator_2_2= LessThanSignEqualsSign | lv_operator_2_3= EqualsSignEqualsSign | lv_operator_2_4= GreaterThanSignEqualsSign | lv_operator_2_5= GreaterThanSign | lv_operator_2_6= ExclamationMarkEqualsSign ) ) ) ( (lv_right_3_0= ruleBooleanNegationExpression ) ) )* )
            {
            // InternalUSFLanguageParser.g:2106:2: (this_BooleanNegationExpression_0= ruleBooleanNegationExpression ( () ( ( (lv_operator_2_1= LessThanSign | lv_operator_2_2= LessThanSignEqualsSign | lv_operator_2_3= EqualsSignEqualsSign | lv_operator_2_4= GreaterThanSignEqualsSign | lv_operator_2_5= GreaterThanSign | lv_operator_2_6= ExclamationMarkEqualsSign ) ) ) ( (lv_right_3_0= ruleBooleanNegationExpression ) ) )* )
            // InternalUSFLanguageParser.g:2107:3: this_BooleanNegationExpression_0= ruleBooleanNegationExpression ( () ( ( (lv_operator_2_1= LessThanSign | lv_operator_2_2= LessThanSignEqualsSign | lv_operator_2_3= EqualsSignEqualsSign | lv_operator_2_4= GreaterThanSignEqualsSign | lv_operator_2_5= GreaterThanSign | lv_operator_2_6= ExclamationMarkEqualsSign ) ) ) ( (lv_right_3_0= ruleBooleanNegationExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getComparisonBooleanExpressionAccess().getBooleanNegationExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_39);
            this_BooleanNegationExpression_0=ruleBooleanNegationExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_BooleanNegationExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalUSFLanguageParser.g:2115:3: ( () ( ( (lv_operator_2_1= LessThanSign | lv_operator_2_2= LessThanSignEqualsSign | lv_operator_2_3= EqualsSignEqualsSign | lv_operator_2_4= GreaterThanSignEqualsSign | lv_operator_2_5= GreaterThanSign | lv_operator_2_6= ExclamationMarkEqualsSign ) ) ) ( (lv_right_3_0= ruleBooleanNegationExpression ) ) )*
            loop34:
            do {
                int alt34=2;
                int LA34_0 = input.LA(1);

                if ( (LA34_0==ExclamationMarkEqualsSign||(LA34_0>=LessThanSignEqualsSign && LA34_0<=GreaterThanSignEqualsSign)||LA34_0==LessThanSign||LA34_0==GreaterThanSign) ) {
                    alt34=1;
                }


                switch (alt34) {
            	case 1 :
            	    // InternalUSFLanguageParser.g:2116:4: () ( ( (lv_operator_2_1= LessThanSign | lv_operator_2_2= LessThanSignEqualsSign | lv_operator_2_3= EqualsSignEqualsSign | lv_operator_2_4= GreaterThanSignEqualsSign | lv_operator_2_5= GreaterThanSign | lv_operator_2_6= ExclamationMarkEqualsSign ) ) ) ( (lv_right_3_0= ruleBooleanNegationExpression ) )
            	    {
            	    // InternalUSFLanguageParser.g:2116:4: ()
            	    // InternalUSFLanguageParser.g:2117:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getComparisonBooleanExpressionAccess().getComparisonBooleanExpressionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalUSFLanguageParser.g:2123:4: ( ( (lv_operator_2_1= LessThanSign | lv_operator_2_2= LessThanSignEqualsSign | lv_operator_2_3= EqualsSignEqualsSign | lv_operator_2_4= GreaterThanSignEqualsSign | lv_operator_2_5= GreaterThanSign | lv_operator_2_6= ExclamationMarkEqualsSign ) ) )
            	    // InternalUSFLanguageParser.g:2124:5: ( (lv_operator_2_1= LessThanSign | lv_operator_2_2= LessThanSignEqualsSign | lv_operator_2_3= EqualsSignEqualsSign | lv_operator_2_4= GreaterThanSignEqualsSign | lv_operator_2_5= GreaterThanSign | lv_operator_2_6= ExclamationMarkEqualsSign ) )
            	    {
            	    // InternalUSFLanguageParser.g:2124:5: ( (lv_operator_2_1= LessThanSign | lv_operator_2_2= LessThanSignEqualsSign | lv_operator_2_3= EqualsSignEqualsSign | lv_operator_2_4= GreaterThanSignEqualsSign | lv_operator_2_5= GreaterThanSign | lv_operator_2_6= ExclamationMarkEqualsSign ) )
            	    // InternalUSFLanguageParser.g:2125:6: (lv_operator_2_1= LessThanSign | lv_operator_2_2= LessThanSignEqualsSign | lv_operator_2_3= EqualsSignEqualsSign | lv_operator_2_4= GreaterThanSignEqualsSign | lv_operator_2_5= GreaterThanSign | lv_operator_2_6= ExclamationMarkEqualsSign )
            	    {
            	    // InternalUSFLanguageParser.g:2125:6: (lv_operator_2_1= LessThanSign | lv_operator_2_2= LessThanSignEqualsSign | lv_operator_2_3= EqualsSignEqualsSign | lv_operator_2_4= GreaterThanSignEqualsSign | lv_operator_2_5= GreaterThanSign | lv_operator_2_6= ExclamationMarkEqualsSign )
            	    int alt33=6;
            	    switch ( input.LA(1) ) {
            	    case LessThanSign:
            	        {
            	        alt33=1;
            	        }
            	        break;
            	    case LessThanSignEqualsSign:
            	        {
            	        alt33=2;
            	        }
            	        break;
            	    case EqualsSignEqualsSign:
            	        {
            	        alt33=3;
            	        }
            	        break;
            	    case GreaterThanSignEqualsSign:
            	        {
            	        alt33=4;
            	        }
            	        break;
            	    case GreaterThanSign:
            	        {
            	        alt33=5;
            	        }
            	        break;
            	    case ExclamationMarkEqualsSign:
            	        {
            	        alt33=6;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 33, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt33) {
            	        case 1 :
            	            // InternalUSFLanguageParser.g:2126:7: lv_operator_2_1= LessThanSign
            	            {
            	            lv_operator_2_1=(Token)match(input,LessThanSign,FOLLOW_35); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_operator_2_1, grammarAccess.getComparisonBooleanExpressionAccess().getOperatorLessThanSignKeyword_1_1_0_0());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElement(grammarAccess.getComparisonBooleanExpressionRule());
            	              							}
            	              							setWithLastConsumed(current, "operator", lv_operator_2_1, null);
            	              						
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // InternalUSFLanguageParser.g:2137:7: lv_operator_2_2= LessThanSignEqualsSign
            	            {
            	            lv_operator_2_2=(Token)match(input,LessThanSignEqualsSign,FOLLOW_35); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_operator_2_2, grammarAccess.getComparisonBooleanExpressionAccess().getOperatorLessThanSignEqualsSignKeyword_1_1_0_1());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElement(grammarAccess.getComparisonBooleanExpressionRule());
            	              							}
            	              							setWithLastConsumed(current, "operator", lv_operator_2_2, null);
            	              						
            	            }

            	            }
            	            break;
            	        case 3 :
            	            // InternalUSFLanguageParser.g:2148:7: lv_operator_2_3= EqualsSignEqualsSign
            	            {
            	            lv_operator_2_3=(Token)match(input,EqualsSignEqualsSign,FOLLOW_35); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_operator_2_3, grammarAccess.getComparisonBooleanExpressionAccess().getOperatorEqualsSignEqualsSignKeyword_1_1_0_2());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElement(grammarAccess.getComparisonBooleanExpressionRule());
            	              							}
            	              							setWithLastConsumed(current, "operator", lv_operator_2_3, null);
            	              						
            	            }

            	            }
            	            break;
            	        case 4 :
            	            // InternalUSFLanguageParser.g:2159:7: lv_operator_2_4= GreaterThanSignEqualsSign
            	            {
            	            lv_operator_2_4=(Token)match(input,GreaterThanSignEqualsSign,FOLLOW_35); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_operator_2_4, grammarAccess.getComparisonBooleanExpressionAccess().getOperatorGreaterThanSignEqualsSignKeyword_1_1_0_3());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElement(grammarAccess.getComparisonBooleanExpressionRule());
            	              							}
            	              							setWithLastConsumed(current, "operator", lv_operator_2_4, null);
            	              						
            	            }

            	            }
            	            break;
            	        case 5 :
            	            // InternalUSFLanguageParser.g:2170:7: lv_operator_2_5= GreaterThanSign
            	            {
            	            lv_operator_2_5=(Token)match(input,GreaterThanSign,FOLLOW_35); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_operator_2_5, grammarAccess.getComparisonBooleanExpressionAccess().getOperatorGreaterThanSignKeyword_1_1_0_4());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElement(grammarAccess.getComparisonBooleanExpressionRule());
            	              							}
            	              							setWithLastConsumed(current, "operator", lv_operator_2_5, null);
            	              						
            	            }

            	            }
            	            break;
            	        case 6 :
            	            // InternalUSFLanguageParser.g:2181:7: lv_operator_2_6= ExclamationMarkEqualsSign
            	            {
            	            lv_operator_2_6=(Token)match(input,ExclamationMarkEqualsSign,FOLLOW_35); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_operator_2_6, grammarAccess.getComparisonBooleanExpressionAccess().getOperatorExclamationMarkEqualsSignKeyword_1_1_0_5());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElement(grammarAccess.getComparisonBooleanExpressionRule());
            	              							}
            	              							setWithLastConsumed(current, "operator", lv_operator_2_6, null);
            	              						
            	            }

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // InternalUSFLanguageParser.g:2194:4: ( (lv_right_3_0= ruleBooleanNegationExpression ) )
            	    // InternalUSFLanguageParser.g:2195:5: (lv_right_3_0= ruleBooleanNegationExpression )
            	    {
            	    // InternalUSFLanguageParser.g:2195:5: (lv_right_3_0= ruleBooleanNegationExpression )
            	    // InternalUSFLanguageParser.g:2196:6: lv_right_3_0= ruleBooleanNegationExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getComparisonBooleanExpressionAccess().getRightBooleanNegationExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_39);
            	    lv_right_3_0=ruleBooleanNegationExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getComparisonBooleanExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"org.safe4i.usf.transformation.language.USFLanguage.BooleanNegationExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop34;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleComparisonBooleanExpression"


    // $ANTLR start "entryRuleBooleanNegationExpression"
    // InternalUSFLanguageParser.g:2218:1: entryRuleBooleanNegationExpression returns [EObject current=null] : iv_ruleBooleanNegationExpression= ruleBooleanNegationExpression EOF ;
    public final EObject entryRuleBooleanNegationExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanNegationExpression = null;


        try {
            // InternalUSFLanguageParser.g:2218:66: (iv_ruleBooleanNegationExpression= ruleBooleanNegationExpression EOF )
            // InternalUSFLanguageParser.g:2219:2: iv_ruleBooleanNegationExpression= ruleBooleanNegationExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBooleanNegationExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBooleanNegationExpression=ruleBooleanNegationExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBooleanNegationExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleBooleanNegationExpression"


    // $ANTLR start "ruleBooleanNegationExpression"
    // InternalUSFLanguageParser.g:2225:1: ruleBooleanNegationExpression returns [EObject current=null] : ( () ( ( ( ( ExclamationMark ) ) )=> ( (lv_isNegate_1_0= ExclamationMark ) ) )? ( (lv_expression_2_0= ruleAtomic ) ) ) ;
    public final EObject ruleBooleanNegationExpression() throws RecognitionException {
        EObject current = null;

        Token lv_isNegate_1_0=null;
        EObject lv_expression_2_0 = null;



        	enterRule();

        try {
            // InternalUSFLanguageParser.g:2231:2: ( ( () ( ( ( ( ExclamationMark ) ) )=> ( (lv_isNegate_1_0= ExclamationMark ) ) )? ( (lv_expression_2_0= ruleAtomic ) ) ) )
            // InternalUSFLanguageParser.g:2232:2: ( () ( ( ( ( ExclamationMark ) ) )=> ( (lv_isNegate_1_0= ExclamationMark ) ) )? ( (lv_expression_2_0= ruleAtomic ) ) )
            {
            // InternalUSFLanguageParser.g:2232:2: ( () ( ( ( ( ExclamationMark ) ) )=> ( (lv_isNegate_1_0= ExclamationMark ) ) )? ( (lv_expression_2_0= ruleAtomic ) ) )
            // InternalUSFLanguageParser.g:2233:3: () ( ( ( ( ExclamationMark ) ) )=> ( (lv_isNegate_1_0= ExclamationMark ) ) )? ( (lv_expression_2_0= ruleAtomic ) )
            {
            // InternalUSFLanguageParser.g:2233:3: ()
            // InternalUSFLanguageParser.g:2234:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getBooleanNegationExpressionAccess().getBooleanNegationExpressionAction_0(),
              					current);
              			
            }

            }

            // InternalUSFLanguageParser.g:2240:3: ( ( ( ( ExclamationMark ) ) )=> ( (lv_isNegate_1_0= ExclamationMark ) ) )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==ExclamationMark) && (synpred5_InternalUSFLanguageParser())) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // InternalUSFLanguageParser.g:2241:4: ( ( ( ExclamationMark ) ) )=> ( (lv_isNegate_1_0= ExclamationMark ) )
                    {
                    // InternalUSFLanguageParser.g:2247:4: ( (lv_isNegate_1_0= ExclamationMark ) )
                    // InternalUSFLanguageParser.g:2248:5: (lv_isNegate_1_0= ExclamationMark )
                    {
                    // InternalUSFLanguageParser.g:2248:5: (lv_isNegate_1_0= ExclamationMark )
                    // InternalUSFLanguageParser.g:2249:6: lv_isNegate_1_0= ExclamationMark
                    {
                    lv_isNegate_1_0=(Token)match(input,ExclamationMark,FOLLOW_35); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_isNegate_1_0, grammarAccess.getBooleanNegationExpressionAccess().getIsNegateExclamationMarkKeyword_1_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getBooleanNegationExpressionRule());
                      						}
                      						setWithLastConsumed(current, "isNegate", lv_isNegate_1_0 != null, "!");
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalUSFLanguageParser.g:2262:3: ( (lv_expression_2_0= ruleAtomic ) )
            // InternalUSFLanguageParser.g:2263:4: (lv_expression_2_0= ruleAtomic )
            {
            // InternalUSFLanguageParser.g:2263:4: (lv_expression_2_0= ruleAtomic )
            // InternalUSFLanguageParser.g:2264:5: lv_expression_2_0= ruleAtomic
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getBooleanNegationExpressionAccess().getExpressionAtomicParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_expression_2_0=ruleAtomic();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getBooleanNegationExpressionRule());
              					}
              					set(
              						current,
              						"expression",
              						lv_expression_2_0,
              						"org.safe4i.usf.transformation.language.USFLanguage.Atomic");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleBooleanNegationExpression"


    // $ANTLR start "entryRuleAtomic"
    // InternalUSFLanguageParser.g:2285:1: entryRuleAtomic returns [EObject current=null] : iv_ruleAtomic= ruleAtomic EOF ;
    public final EObject entryRuleAtomic() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAtomic = null;


        try {
            // InternalUSFLanguageParser.g:2285:47: (iv_ruleAtomic= ruleAtomic EOF )
            // InternalUSFLanguageParser.g:2286:2: iv_ruleAtomic= ruleAtomic EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAtomicRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAtomic=ruleAtomic();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAtomic; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

            }

        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAtomic"


    // $ANTLR start "ruleAtomic"
    // InternalUSFLanguageParser.g:2292:1: ruleAtomic returns [EObject current=null] : ( (otherlv_0= LeftParenthesis this_Expression_1= ruleExpression otherlv_2= RightParenthesis ) | this_StringLiteral_3= ruleStringLiteral | this_BooleanLiteral_4= ruleBooleanLiteral | this_NullLiteral_5= ruleNullLiteral | this_PortDirectionLiteral_6= rulePortDirectionLiteral | this_NumberLiteral_7= ruleNumberLiteral | this_FeatureCallExpression_8= ruleFeatureCallExpression | this_TypedMemberCallExpression_9= ruleTypedMemberCallExpression ) ;
    public final EObject ruleAtomic() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject this_Expression_1 = null;

        EObject this_StringLiteral_3 = null;

        EObject this_BooleanLiteral_4 = null;

        EObject this_NullLiteral_5 = null;

        EObject this_PortDirectionLiteral_6 = null;

        EObject this_NumberLiteral_7 = null;

        EObject this_FeatureCallExpression_8 = null;

        EObject this_TypedMemberCallExpression_9 = null;



        	enterRule();

        try {
            // InternalUSFLanguageParser.g:2298:2: ( ( (otherlv_0= LeftParenthesis this_Expression_1= ruleExpression otherlv_2= RightParenthesis ) | this_StringLiteral_3= ruleStringLiteral | this_BooleanLiteral_4= ruleBooleanLiteral | this_NullLiteral_5= ruleNullLiteral | this_PortDirectionLiteral_6= rulePortDirectionLiteral | this_NumberLiteral_7= ruleNumberLiteral | this_FeatureCallExpression_8= ruleFeatureCallExpression | this_TypedMemberCallExpression_9= ruleTypedMemberCallExpression ) )
            // InternalUSFLanguageParser.g:2299:2: ( (otherlv_0= LeftParenthesis this_Expression_1= ruleExpression otherlv_2= RightParenthesis ) | this_StringLiteral_3= ruleStringLiteral | this_BooleanLiteral_4= ruleBooleanLiteral | this_NullLiteral_5= ruleNullLiteral | this_PortDirectionLiteral_6= rulePortDirectionLiteral | this_NumberLiteral_7= ruleNumberLiteral | this_FeatureCallExpression_8= ruleFeatureCallExpression | this_TypedMemberCallExpression_9= ruleTypedMemberCallExpression )
            {
            // InternalUSFLanguageParser.g:2299:2: ( (otherlv_0= LeftParenthesis this_Expression_1= ruleExpression otherlv_2= RightParenthesis ) | this_StringLiteral_3= ruleStringLiteral | this_BooleanLiteral_4= ruleBooleanLiteral | this_NullLiteral_5= ruleNullLiteral | this_PortDirectionLiteral_6= rulePortDirectionLiteral | this_NumberLiteral_7= ruleNumberLiteral | this_FeatureCallExpression_8= ruleFeatureCallExpression | this_TypedMemberCallExpression_9= ruleTypedMemberCallExpression )
            int alt36=8;
            alt36 = dfa36.predict(input);
            switch (alt36) {
                case 1 :
                    // InternalUSFLanguageParser.g:2300:3: (otherlv_0= LeftParenthesis this_Expression_1= ruleExpression otherlv_2= RightParenthesis )
                    {
                    // InternalUSFLanguageParser.g:2300:3: (otherlv_0= LeftParenthesis this_Expression_1= ruleExpression otherlv_2= RightParenthesis )
                    // InternalUSFLanguageParser.g:2301:4: otherlv_0= LeftParenthesis this_Expression_1= ruleExpression otherlv_2= RightParenthesis
                    {
                    otherlv_0=(Token)match(input,LeftParenthesis,FOLLOW_16); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_0, grammarAccess.getAtomicAccess().getLeftParenthesisKeyword_0_0());
                      			
                    }
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getAtomicAccess().getExpressionParserRuleCall_0_1());
                      			
                    }
                    pushFollow(FOLLOW_33);
                    this_Expression_1=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_Expression_1;
                      				afterParserOrEnumRuleCall();
                      			
                    }
                    otherlv_2=(Token)match(input,RightParenthesis,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_2, grammarAccess.getAtomicAccess().getRightParenthesisKeyword_0_2());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalUSFLanguageParser.g:2319:3: this_StringLiteral_3= ruleStringLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getAtomicAccess().getStringLiteralParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_StringLiteral_3=ruleStringLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_StringLiteral_3;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalUSFLanguageParser.g:2328:3: this_BooleanLiteral_4= ruleBooleanLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getAtomicAccess().getBooleanLiteralParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_BooleanLiteral_4=ruleBooleanLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_BooleanLiteral_4;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalUSFLanguageParser.g:2337:3: this_NullLiteral_5= ruleNullLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getAtomicAccess().getNullLiteralParserRuleCall_3());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_NullLiteral_5=ruleNullLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_NullLiteral_5;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalUSFLanguageParser.g:2346:3: this_PortDirectionLiteral_6= rulePortDirectionLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getAtomicAccess().getPortDirectionLiteralParserRuleCall_4());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_PortDirectionLiteral_6=rulePortDirectionLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_PortDirectionLiteral_6;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 6 :
                    // InternalUSFLanguageParser.g:2355:3: this_NumberLiteral_7= ruleNumberLiteral
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getAtomicAccess().getNumberLiteralParserRuleCall_5());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_NumberLiteral_7=ruleNumberLiteral();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_NumberLiteral_7;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 7 :
                    // InternalUSFLanguageParser.g:2364:3: this_FeatureCallExpression_8= ruleFeatureCallExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getAtomicAccess().getFeatureCallExpressionParserRuleCall_6());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_FeatureCallExpression_8=ruleFeatureCallExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_FeatureCallExpression_8;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 8 :
                    // InternalUSFLanguageParser.g:2373:3: this_TypedMemberCallExpression_9= ruleTypedMemberCallExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getAtomicAccess().getTypedMemberCallExpressionParserRuleCall_7());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_TypedMemberCallExpression_9=ruleTypedMemberCallExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_TypedMemberCallExpression_9;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAtomic"


    // $ANTLR start "ruleTransformationTypes"
    // InternalUSFLanguageParser.g:2385:1: ruleTransformationTypes returns [Enumerator current=null] : ( (enumLiteral_0= Integer ) | (enumLiteral_1= Float ) | (enumLiteral_2= String ) | (enumLiteral_3= Boolean ) | (enumLiteral_4= Void ) ) ;
    public final Enumerator ruleTransformationTypes() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;
        Token enumLiteral_4=null;


        	enterRule();

        try {
            // InternalUSFLanguageParser.g:2391:2: ( ( (enumLiteral_0= Integer ) | (enumLiteral_1= Float ) | (enumLiteral_2= String ) | (enumLiteral_3= Boolean ) | (enumLiteral_4= Void ) ) )
            // InternalUSFLanguageParser.g:2392:2: ( (enumLiteral_0= Integer ) | (enumLiteral_1= Float ) | (enumLiteral_2= String ) | (enumLiteral_3= Boolean ) | (enumLiteral_4= Void ) )
            {
            // InternalUSFLanguageParser.g:2392:2: ( (enumLiteral_0= Integer ) | (enumLiteral_1= Float ) | (enumLiteral_2= String ) | (enumLiteral_3= Boolean ) | (enumLiteral_4= Void ) )
            int alt37=5;
            switch ( input.LA(1) ) {
            case Integer:
                {
                alt37=1;
                }
                break;
            case Float:
                {
                alt37=2;
                }
                break;
            case String:
                {
                alt37=3;
                }
                break;
            case Boolean:
                {
                alt37=4;
                }
                break;
            case Void:
                {
                alt37=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;
            }

            switch (alt37) {
                case 1 :
                    // InternalUSFLanguageParser.g:2393:3: (enumLiteral_0= Integer )
                    {
                    // InternalUSFLanguageParser.g:2393:3: (enumLiteral_0= Integer )
                    // InternalUSFLanguageParser.g:2394:4: enumLiteral_0= Integer
                    {
                    enumLiteral_0=(Token)match(input,Integer,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getTransformationTypesAccess().getIntegerEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getTransformationTypesAccess().getIntegerEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalUSFLanguageParser.g:2401:3: (enumLiteral_1= Float )
                    {
                    // InternalUSFLanguageParser.g:2401:3: (enumLiteral_1= Float )
                    // InternalUSFLanguageParser.g:2402:4: enumLiteral_1= Float
                    {
                    enumLiteral_1=(Token)match(input,Float,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getTransformationTypesAccess().getFloatEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getTransformationTypesAccess().getFloatEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalUSFLanguageParser.g:2409:3: (enumLiteral_2= String )
                    {
                    // InternalUSFLanguageParser.g:2409:3: (enumLiteral_2= String )
                    // InternalUSFLanguageParser.g:2410:4: enumLiteral_2= String
                    {
                    enumLiteral_2=(Token)match(input,String,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getTransformationTypesAccess().getStringEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getTransformationTypesAccess().getStringEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalUSFLanguageParser.g:2417:3: (enumLiteral_3= Boolean )
                    {
                    // InternalUSFLanguageParser.g:2417:3: (enumLiteral_3= Boolean )
                    // InternalUSFLanguageParser.g:2418:4: enumLiteral_3= Boolean
                    {
                    enumLiteral_3=(Token)match(input,Boolean,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getTransformationTypesAccess().getBooleanEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_3, grammarAccess.getTransformationTypesAccess().getBooleanEnumLiteralDeclaration_3());
                      			
                    }

                    }


                    }
                    break;
                case 5 :
                    // InternalUSFLanguageParser.g:2425:3: (enumLiteral_4= Void )
                    {
                    // InternalUSFLanguageParser.g:2425:3: (enumLiteral_4= Void )
                    // InternalUSFLanguageParser.g:2426:4: enumLiteral_4= Void
                    {
                    enumLiteral_4=(Token)match(input,Void,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getTransformationTypesAccess().getVoidEnumLiteralDeclaration_4().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_4, grammarAccess.getTransformationTypesAccess().getVoidEnumLiteralDeclaration_4());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTransformationTypes"


    // $ANTLR start "rulePortDirection"
    // InternalUSFLanguageParser.g:2436:1: rulePortDirection returns [Enumerator current=null] : ( (enumLiteral_0= PortDirectionIN ) | (enumLiteral_1= PortDirectionOUT ) | (enumLiteral_2= PortDirectionINOUT ) | (enumLiteral_3= PortDirectionUNSET ) ) ;
    public final Enumerator rulePortDirection() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;
        Token enumLiteral_3=null;


        	enterRule();

        try {
            // InternalUSFLanguageParser.g:2442:2: ( ( (enumLiteral_0= PortDirectionIN ) | (enumLiteral_1= PortDirectionOUT ) | (enumLiteral_2= PortDirectionINOUT ) | (enumLiteral_3= PortDirectionUNSET ) ) )
            // InternalUSFLanguageParser.g:2443:2: ( (enumLiteral_0= PortDirectionIN ) | (enumLiteral_1= PortDirectionOUT ) | (enumLiteral_2= PortDirectionINOUT ) | (enumLiteral_3= PortDirectionUNSET ) )
            {
            // InternalUSFLanguageParser.g:2443:2: ( (enumLiteral_0= PortDirectionIN ) | (enumLiteral_1= PortDirectionOUT ) | (enumLiteral_2= PortDirectionINOUT ) | (enumLiteral_3= PortDirectionUNSET ) )
            int alt38=4;
            switch ( input.LA(1) ) {
            case PortDirectionIN:
                {
                alt38=1;
                }
                break;
            case PortDirectionOUT:
                {
                alt38=2;
                }
                break;
            case PortDirectionINOUT:
                {
                alt38=3;
                }
                break;
            case PortDirectionUNSET:
                {
                alt38=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;
            }

            switch (alt38) {
                case 1 :
                    // InternalUSFLanguageParser.g:2444:3: (enumLiteral_0= PortDirectionIN )
                    {
                    // InternalUSFLanguageParser.g:2444:3: (enumLiteral_0= PortDirectionIN )
                    // InternalUSFLanguageParser.g:2445:4: enumLiteral_0= PortDirectionIN
                    {
                    enumLiteral_0=(Token)match(input,PortDirectionIN,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getPortDirectionAccess().getINEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_0, grammarAccess.getPortDirectionAccess().getINEnumLiteralDeclaration_0());
                      			
                    }

                    }


                    }
                    break;
                case 2 :
                    // InternalUSFLanguageParser.g:2452:3: (enumLiteral_1= PortDirectionOUT )
                    {
                    // InternalUSFLanguageParser.g:2452:3: (enumLiteral_1= PortDirectionOUT )
                    // InternalUSFLanguageParser.g:2453:4: enumLiteral_1= PortDirectionOUT
                    {
                    enumLiteral_1=(Token)match(input,PortDirectionOUT,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getPortDirectionAccess().getOUTEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_1, grammarAccess.getPortDirectionAccess().getOUTEnumLiteralDeclaration_1());
                      			
                    }

                    }


                    }
                    break;
                case 3 :
                    // InternalUSFLanguageParser.g:2460:3: (enumLiteral_2= PortDirectionINOUT )
                    {
                    // InternalUSFLanguageParser.g:2460:3: (enumLiteral_2= PortDirectionINOUT )
                    // InternalUSFLanguageParser.g:2461:4: enumLiteral_2= PortDirectionINOUT
                    {
                    enumLiteral_2=(Token)match(input,PortDirectionINOUT,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getPortDirectionAccess().getINOUTEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_2, grammarAccess.getPortDirectionAccess().getINOUTEnumLiteralDeclaration_2());
                      			
                    }

                    }


                    }
                    break;
                case 4 :
                    // InternalUSFLanguageParser.g:2468:3: (enumLiteral_3= PortDirectionUNSET )
                    {
                    // InternalUSFLanguageParser.g:2468:3: (enumLiteral_3= PortDirectionUNSET )
                    // InternalUSFLanguageParser.g:2469:4: enumLiteral_3= PortDirectionUNSET
                    {
                    enumLiteral_3=(Token)match(input,PortDirectionUNSET,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = grammarAccess.getPortDirectionAccess().getUNSETEnumLiteralDeclaration_3().getEnumLiteral().getInstance();
                      				newLeafNode(enumLiteral_3, grammarAccess.getPortDirectionAccess().getUNSETEnumLiteralDeclaration_3());
                      			
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {

              	leaveRule();

            }
        }

            catch (RecognitionException re) {
                recover(input,re);
                appendSkippedTokens();
            }
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePortDirection"

    // $ANTLR start synpred1_InternalUSFLanguageParser
    public final void synpred1_InternalUSFLanguageParser_fragment() throws RecognitionException {   
        // InternalUSFLanguageParser.g:353:4: ( ( () For LeftParenthesis ( ( ruleParameter ) ) In ) )
        // InternalUSFLanguageParser.g:353:5: ( () For LeftParenthesis ( ( ruleParameter ) ) In )
        {
        // InternalUSFLanguageParser.g:353:5: ( () For LeftParenthesis ( ( ruleParameter ) ) In )
        // InternalUSFLanguageParser.g:354:5: () For LeftParenthesis ( ( ruleParameter ) ) In
        {
        // InternalUSFLanguageParser.g:354:5: ()
        // InternalUSFLanguageParser.g:355:5: 
        {
        }

        match(input,For,FOLLOW_4); if (state.failed) return ;
        match(input,LeftParenthesis,FOLLOW_3); if (state.failed) return ;
        // InternalUSFLanguageParser.g:358:5: ( ( ruleParameter ) )
        // InternalUSFLanguageParser.g:359:6: ( ruleParameter )
        {
        // InternalUSFLanguageParser.g:359:6: ( ruleParameter )
        // InternalUSFLanguageParser.g:360:7: ruleParameter
        {
        pushFollow(FOLLOW_32);
        ruleParameter();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        match(input,In,FOLLOW_2); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred1_InternalUSFLanguageParser

    // $ANTLR start synpred2_InternalUSFLanguageParser
    public final void synpred2_InternalUSFLanguageParser_fragment() throws RecognitionException {   
        // InternalUSFLanguageParser.g:1468:5: ( ( ( ( ruleTransformationType ) ) ( ( RULE_ID ) ) ) )
        // InternalUSFLanguageParser.g:1468:6: ( ( ( ruleTransformationType ) ) ( ( RULE_ID ) ) )
        {
        // InternalUSFLanguageParser.g:1468:6: ( ( ( ruleTransformationType ) ) ( ( RULE_ID ) ) )
        // InternalUSFLanguageParser.g:1469:6: ( ( ruleTransformationType ) ) ( ( RULE_ID ) )
        {
        // InternalUSFLanguageParser.g:1469:6: ( ( ruleTransformationType ) )
        // InternalUSFLanguageParser.g:1470:7: ( ruleTransformationType )
        {
        // InternalUSFLanguageParser.g:1470:7: ( ruleTransformationType )
        // InternalUSFLanguageParser.g:1471:8: ruleTransformationType
        {
        pushFollow(FOLLOW_3);
        ruleTransformationType();

        state._fsp--;
        if (state.failed) return ;

        }


        }

        // InternalUSFLanguageParser.g:1474:6: ( ( RULE_ID ) )
        // InternalUSFLanguageParser.g:1475:7: ( RULE_ID )
        {
        // InternalUSFLanguageParser.g:1475:7: ( RULE_ID )
        // InternalUSFLanguageParser.g:1476:8: RULE_ID
        {
        match(input,RULE_ID,FOLLOW_2); if (state.failed) return ;

        }


        }


        }


        }
    }
    // $ANTLR end synpred2_InternalUSFLanguageParser

    // $ANTLR start synpred4_InternalUSFLanguageParser
    public final void synpred4_InternalUSFLanguageParser_fragment() throws RecognitionException {   
        // InternalUSFLanguageParser.g:1897:5: ( Else )
        // InternalUSFLanguageParser.g:1897:6: Else
        {
        match(input,Else,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred4_InternalUSFLanguageParser

    // $ANTLR start synpred5_InternalUSFLanguageParser
    public final void synpred5_InternalUSFLanguageParser_fragment() throws RecognitionException {   
        // InternalUSFLanguageParser.g:2241:4: ( ( ( ExclamationMark ) ) )
        // InternalUSFLanguageParser.g:2241:5: ( ( ExclamationMark ) )
        {
        // InternalUSFLanguageParser.g:2241:5: ( ( ExclamationMark ) )
        // InternalUSFLanguageParser.g:2242:5: ( ExclamationMark )
        {
        // InternalUSFLanguageParser.g:2242:5: ( ExclamationMark )
        // InternalUSFLanguageParser.g:2243:6: ExclamationMark
        {
        match(input,ExclamationMark,FOLLOW_2); if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred5_InternalUSFLanguageParser

    // Delegated rules

    public final boolean synpred2_InternalUSFLanguageParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_InternalUSFLanguageParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred1_InternalUSFLanguageParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_InternalUSFLanguageParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred5_InternalUSFLanguageParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred5_InternalUSFLanguageParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred4_InternalUSFLanguageParser() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred4_InternalUSFLanguageParser_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA22 dfa22 = new DFA22(this);
    protected DFA36 dfa36 = new DFA36(this);
    static final String dfa_1s = "\12\uffff";
    static final String dfa_2s = "\6\uffff\1\11\3\uffff";
    static final String dfa_3s = "\1\12\5\uffff\1\4\1\uffff\1\0\1\uffff";
    static final String dfa_4s = "\1\57\5\uffff\1\61\1\uffff\1\0\1\uffff";
    static final String dfa_5s = "\1\uffff\5\1\1\uffff\1\1\1\uffff\1\2";
    static final String dfa_6s = "\1\0\7\uffff\1\1\1\uffff}>";
    static final String[] dfa_7s = {
            "\1\4\1\1\1\uffff\1\3\2\uffff\1\2\1\7\3\uffff\1\5\31\uffff\1\6",
            "",
            "",
            "",
            "",
            "",
            "\4\11\7\uffff\1\11\3\uffff\2\11\1\uffff\3\11\5\uffff\1\11\4\uffff\1\11\1\uffff\1\11\3\uffff\1\11\4\uffff\1\11\1\10\2\11",
            "",
            "\1\uffff",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
    static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

    class DFA22 extends DFA {

        public DFA22(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 22;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "1466:3: ( ( ( ( ( ( ruleTransformationType ) ) ( ( RULE_ID ) ) ) )=> ( ( (lv_type_3_0= ruleTransformationType ) ) ( (lv_name_4_0= RULE_ID ) ) ) ) | ( (lv_name_5_0= RULE_ID ) ) )";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA22_0 = input.LA(1);

                         
                        int index22_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA22_0==Integer) && (synpred2_InternalUSFLanguageParser())) {s = 1;}

                        else if ( (LA22_0==Float) && (synpred2_InternalUSFLanguageParser())) {s = 2;}

                        else if ( (LA22_0==String) && (synpred2_InternalUSFLanguageParser())) {s = 3;}

                        else if ( (LA22_0==Boolean) && (synpred2_InternalUSFLanguageParser())) {s = 4;}

                        else if ( (LA22_0==Void) && (synpred2_InternalUSFLanguageParser())) {s = 5;}

                        else if ( (LA22_0==RULE_ID) ) {s = 6;}

                        else if ( (LA22_0==List) && (synpred2_InternalUSFLanguageParser())) {s = 7;}

                         
                        input.seek(index22_0);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA22_8 = input.LA(1);

                         
                        int index22_8 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred2_InternalUSFLanguageParser()) ) {s = 7;}

                        else if ( (true) ) {s = 9;}

                         
                        input.seek(index22_8);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 22, _s, input);
            error(nvae);
            throw nvae;
        }
    }
    static final String dfa_8s = "\7\uffff\1\10\2\uffff";
    static final String dfa_9s = "\1\4\6\uffff\1\31\2\uffff";
    static final String dfa_10s = "\1\61\6\uffff\1\52\2\uffff";
    static final String dfa_11s = "\1\uffff\1\1\1\2\1\3\1\4\1\5\1\6\1\uffff\1\10\1\7";
    static final String dfa_12s = "\12\uffff}>";
    static final String[] dfa_13s = {
            "\4\5\7\uffff\1\3\3\uffff\1\4\1\3\15\uffff\1\1\14\uffff\1\7\1\6\1\2",
            "",
            "",
            "",
            "",
            "",
            "",
            "\5\10\2\uffff\1\10\2\uffff\1\10\2\uffff\1\11\1\uffff\1\10\1\uffff\1\10",
            "",
            ""
    };
    static final short[] dfa_8 = DFA.unpackEncodedString(dfa_8s);
    static final char[] dfa_9 = DFA.unpackEncodedStringToUnsignedChars(dfa_9s);
    static final char[] dfa_10 = DFA.unpackEncodedStringToUnsignedChars(dfa_10s);
    static final short[] dfa_11 = DFA.unpackEncodedString(dfa_11s);
    static final short[] dfa_12 = DFA.unpackEncodedString(dfa_12s);
    static final short[][] dfa_13 = unpackEncodedStringArray(dfa_13s);

    class DFA36 extends DFA {

        public DFA36(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 36;
            this.eot = dfa_1;
            this.eof = dfa_8;
            this.min = dfa_9;
            this.max = dfa_10;
            this.accept = dfa_11;
            this.special = dfa_12;
            this.transition = dfa_13;
        }
        public String getDescription() {
            return "2299:2: ( (otherlv_0= LeftParenthesis this_Expression_1= ruleExpression otherlv_2= RightParenthesis ) | this_StringLiteral_3= ruleStringLiteral | this_BooleanLiteral_4= ruleBooleanLiteral | this_NullLiteral_5= ruleNullLiteral | this_PortDirectionLiteral_6= rulePortDirectionLiteral | this_NumberLiteral_7= ruleNumberLiteral | this_FeatureCallExpression_8= ruleFeatureCallExpression | this_TypedMemberCallExpression_9= ruleTypedMemberCallExpression )";
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000800800000000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000002800000000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000088000000000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000800000232C00L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000000100L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0003C00041D880F0L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000100000001000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0003800041D880F0L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000000212C00L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0001000000000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000804000000000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000400000002L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0003800841D880F0L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000020000000002L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000300000000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0003800641D880F0L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x000005003A000002L});

}