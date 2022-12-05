/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.sourceforge.htmlunit.xerces.impl.dtd;

import net.sourceforge.htmlunit.xerces.impl.Constants;
import net.sourceforge.htmlunit.xerces.impl.XML11DTDScannerImpl;
import net.sourceforge.htmlunit.xerces.impl.XMLDTDScannerImpl;
import net.sourceforge.htmlunit.xerces.impl.XMLEntityManager;
import net.sourceforge.htmlunit.xerces.impl.XMLErrorReporter;
import net.sourceforge.htmlunit.xerces.util.SymbolTable;
import net.sourceforge.htmlunit.xerces.util.XML11Char;
import net.sourceforge.htmlunit.xerces.xni.grammars.XMLGrammarPool;
import net.sourceforge.htmlunit.xerces.xni.parser.XMLEntityResolver;

/**
 * This class extends XMLDTDProcessor by giving it
 * the ability to parse XML 1.1 documents correctly.  It can also be used
 * as a DTD loader, so that XML 1.1 external subsets can
 * be processed correctly (hence it's rather anomalous-appearing
 * derivation from XMLDTDLoader).
 * <p>
 *
 * @author Neil Graham, IBM
 */
public class XML11DTDProcessor extends XMLDTDLoader{

    // constructors

    public XML11DTDProcessor() {
        super();
    } // <init>()

    public XML11DTDProcessor(SymbolTable symbolTable) {
        super(symbolTable);
    } // init(SymbolTable)

    public XML11DTDProcessor(SymbolTable symbolTable,
                XMLGrammarPool grammarPool) {
        super(symbolTable, grammarPool);
    } // init(SymbolTable, XMLGrammarPool)

    XML11DTDProcessor(SymbolTable symbolTable,
                XMLGrammarPool grammarPool, XMLErrorReporter errorReporter,
                XMLEntityResolver entityResolver) {
        super(symbolTable, grammarPool, errorReporter, entityResolver);
    } // init(SymbolTable, XMLGrammarPool, XMLErrorReporter, XMLEntityResolver)

    // overridden methods

    @Override
    protected boolean isValidNmtoken(String nmtoken) {
        return XML11Char.isXML11ValidNmtoken(nmtoken);
    } // isValidNmtoken(String):  boolean

    @Override
    protected boolean isValidName(String name) {
        return XML11Char.isXML11ValidName(name);
    } // isValidNmtoken(String):  boolean

    @Override
    protected XMLDTDScannerImpl createDTDScanner(SymbolTable symbolTable,
            XMLErrorReporter errorReporter, XMLEntityManager entityManager) {
        return new XML11DTDScannerImpl(symbolTable, errorReporter, entityManager);
    } // createDTDScanner(SymbolTable, XMLErrorReporter, XMLEntityManager) : XMLDTDScannerImpl

    @Override
    protected short getScannerVersion() {
        return Constants.XML_VERSION_1_1;
    } // getScannerVersion() : short

} // class XML11DTDProcessor
