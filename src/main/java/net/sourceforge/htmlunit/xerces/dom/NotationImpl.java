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

package net.sourceforge.htmlunit.xerces.dom;

import org.w3c.dom.DOMException;
import org.w3c.dom.Node;
import org.w3c.dom.Notation;

import net.sourceforge.htmlunit.xerces.util.URI;

/**
 * Notations are how the Document Type Description (DTD) records hints
 * about the format of an XML "unparsed entity" -- in other words,
 * non-XML data bound to this document type, which some applications
 * may wish to consult when manipulating the document. A Notation
 * represents a name-value pair, with its nodeName being set to the
 * declared name of the notation.
 * <P>
 * Notations are also used to formally declare the "targets" of
 * Processing Instructions.
 * <P>
 * Note that the Notation's data is non-DOM information; the DOM only
 * records what and where it is.
 * <P>
 * See the XML 1.0 spec, sections 4.7 and 2.6, for more info.
 * <P>
 * Level 1 of the DOM does not support editing Notation contents.
 */
public class NotationImpl
    extends NodeImpl
    implements Notation {

    /** Serialization version. */
    static final long serialVersionUID = -764632195890658402L;

    /** Notation name. */
    protected String name;

    /** Public identifier. */
    protected String publicId;

    /** System identifier. */
    protected String systemId;

    /** Base URI*/
    protected String baseURI;

    // Factory constructor.
    public NotationImpl(CoreDocumentImpl ownerDoc, String name) {
        super(ownerDoc);
        this.name = name;
    }

    /**
     * {@inheritDoc}
     *
     * A short integer indicating what type of node this is. The named
     * constants for this value are defined in the org.w3c.dom.Node interface.
     */
    @Override
    public short getNodeType() {
        return Node.NOTATION_NODE;
    }

    /**
     * {@inheritDoc}
     *
     * Returns the notation name
     */
    @Override
    public String getNodeName() {
        if (needsSyncData()) {
            synchronizeData();
        }
        return name;
    }

    /**
     * {@inheritDoc}
     *
     * The Public Identifier for this Notation. If no public identifier
     * was specified, this will be null.
     */
    @Override
    public String getPublicId() {

        if (needsSyncData()) {
            synchronizeData();
        }
        return publicId;

    }

    /**
     * {@inheritDoc}
     *
     * The System Identifier for this Notation. If no system identifier
     * was specified, this will be null.
     */
    @Override
    public String getSystemId() {

        if (needsSyncData()) {
            synchronizeData();
        }
        return systemId;

    }

    // NON-DOM: The Public Identifier for this Notation. If no public
    // identifier was specified, this will be null.
    public void setPublicId(String id) {

        if (isReadOnly()) {
            throw new DOMException(
            DOMException.NO_MODIFICATION_ALLOWED_ERR,
                DOMMessageFormatter.formatMessage(DOMMessageFormatter.DOM_DOMAIN, "NO_MODIFICATION_ALLOWED_ERR", null));
        }
        if (needsSyncData()) {
            synchronizeData();
        }
        publicId = id;

    }

    // NON-DOM: The System Identifier for this Notation. If no system
    // identifier was specified, this will be null.
    public void setSystemId(String id) {

        if(isReadOnly()) {
            throw new DOMException(
            DOMException.NO_MODIFICATION_ALLOWED_ERR,
                DOMMessageFormatter.formatMessage(DOMMessageFormatter.DOM_DOMAIN, "NO_MODIFICATION_ALLOWED_ERR", null));
        }
        if (needsSyncData()) {
            synchronizeData();
        }
        systemId = id;

    }


    /**
     * {@inheritDoc}
     *
     * Returns the absolute base URI of this node or null if the implementation
     * wasn't able to obtain an absolute URI. Note: If the URI is malformed, a
     * null is returned.
     *
     * @return The absolute base URI of this node or null.
     */
    @Override
    public String getBaseURI() {
        if (needsSyncData()) {
            synchronizeData();
        }
        if (baseURI != null && baseURI.length() != 0 ) {// attribute value is always empty string
            try {
                return new URI(baseURI).toString();
            }
            catch (net.sourceforge.htmlunit.xerces.util.URI.MalformedURIException e){
                // REVISIT: what should happen in this case?
                return null;
            }
        }
        return baseURI;
    }

    // NON-DOM: set base uri
    public void setBaseURI(String uri){
        if (needsSyncData()) {
            synchronizeData();
        }
        baseURI = uri;
    }
}
