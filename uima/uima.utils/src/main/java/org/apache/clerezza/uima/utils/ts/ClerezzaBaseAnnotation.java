/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

/* First created by JCasGen Wed Jul 06 14:49:10 CEST 2011 */
package org.apache.clerezza.uima.utils.ts;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;
import org.apache.uima.jcas.tcas.Annotation;

/** 
 * Updated by JCasGen Sun Aug 21 14:41:29 CEST 2011
 * XML source: /Users/tommasoteofili/Documents/workspaces/clerezza_workspace/trunk/parent/uima/uima.utils/src/main/resources/META-INF/ClerezzaUIMATypeSystemDescriptor.xml
 * @generated */
public class ClerezzaBaseAnnotation extends Annotation {
  /**
   * @generated
   * @ordered
   */
  public final static int typeIndexID = JCasRegistry.register(ClerezzaBaseAnnotation.class);

  /**
   * @generated
   * @ordered
   */
  public final static int type = typeIndexID;

  /** @generated */
  public int getTypeIndexID() {return typeIndexID;}
 
  /**
   * Never called. Disable default constructor
   * 
   * @generated
   */
  protected ClerezzaBaseAnnotation() {}
    
  /**
   * Internal - constructor used by generator
   * 
   * @generated
   */
  public ClerezzaBaseAnnotation(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public ClerezzaBaseAnnotation(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */
  public ClerezzaBaseAnnotation(JCas jcas, int begin, int end) {
    super(jcas);
    setBegin(begin);
    setEnd(end);
    readObject();
  }   

  /** <!-- begin-user-doc --> Write your own initialization here <!-- end-user-doc -->
  @generated modifiable */
  private void readObject() {
  }

  // *--------------*
  // * Feature: uri

  /**
   * getter for uri - gets
   * 
   * @generated
   */
  public String getUri() {
    if (ClerezzaBaseAnnotation_Type.featOkTst && ((ClerezzaBaseAnnotation_Type)jcasType).casFeat_uri == null)
      jcasType.jcas.throwFeatMissing("uri", "org.apache.clerezza.uima.utils.ts.ClerezzaBaseAnnotation");
    return jcasType.ll_cas.ll_getStringValue(addr, ((ClerezzaBaseAnnotation_Type)jcasType).casFeatCode_uri);}
    
  /**
   * setter for uri - sets
   * 
   * @generated
   */
  public void setUri(String v) {
    if (ClerezzaBaseAnnotation_Type.featOkTst && ((ClerezzaBaseAnnotation_Type)jcasType).casFeat_uri == null)
      jcasType.jcas.throwFeatMissing("uri", "org.apache.clerezza.uima.utils.ts.ClerezzaBaseAnnotation");
    jcasType.ll_cas.ll_setStringValue(addr, ((ClerezzaBaseAnnotation_Type)jcasType).casFeatCode_uri, v);}    
  }
