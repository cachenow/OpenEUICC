/*
 * This class file was automatically generated by ASN1bean v1.13.0 (http://www.beanit.com)
 */

package com.truphone.rsp.dto.asn1.rspdefinitions;

import java.io.IOException;
import java.io.EOFException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.io.Serializable;
import com.beanit.asn1bean.ber.*;
import com.beanit.asn1bean.ber.types.*;
import com.beanit.asn1bean.ber.types.string.*;

import com.truphone.rsp.dto.asn1.pkix1explicit88.Certificate;
import com.truphone.rsp.dto.asn1.pkix1explicit88.CertificateList;
import com.truphone.rsp.dto.asn1.pkix1explicit88.Time;
import com.truphone.rsp.dto.asn1.pkix1implicit88.SubjectKeyIdentifier;

public class AuthenticateClientResponseEs11 implements BerType, Serializable {

	private static final long serialVersionUID = 1L;

	private byte[] code = null;
	public static final BerTag tag = new BerTag(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 64);

	private AuthenticateClientOkEs11 authenticateClientOk = null;
	private BerInteger authenticateClientError = null;
	
	public AuthenticateClientResponseEs11() {
	}

	public AuthenticateClientResponseEs11(byte[] code) {
		this.code = code;
	}

	public void setAuthenticateClientOk(AuthenticateClientOkEs11 authenticateClientOk) {
		this.authenticateClientOk = authenticateClientOk;
	}

	public AuthenticateClientOkEs11 getAuthenticateClientOk() {
		return authenticateClientOk;
	}

	public void setAuthenticateClientError(BerInteger authenticateClientError) {
		this.authenticateClientError = authenticateClientError;
	}

	public BerInteger getAuthenticateClientError() {
		return authenticateClientError;
	}

	@Override public int encode(OutputStream reverseOS) throws IOException {
		return encode(reverseOS, true);
	}

	public int encode(OutputStream reverseOS, boolean withTag) throws IOException {

		if (code != null) {
			reverseOS.write(code);
			if (withTag) {
				return tag.encode(reverseOS) + code.length;
			}
			return code.length;
		}

		int codeLength = 0;
		if (authenticateClientError != null) {
			codeLength += authenticateClientError.encode(reverseOS, false);
			// write tag: CONTEXT_CLASS, PRIMITIVE, 1
			reverseOS.write(0x81);
			codeLength += 1;
			codeLength += BerLength.encodeLength(reverseOS, codeLength);
			if (withTag) {
				codeLength += tag.encode(reverseOS);
			}
			return codeLength;
		}
		
		if (authenticateClientOk != null) {
			codeLength += authenticateClientOk.encode(reverseOS, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 0
			reverseOS.write(0xA0);
			codeLength += 1;
			codeLength += BerLength.encodeLength(reverseOS, codeLength);
			if (withTag) {
				codeLength += tag.encode(reverseOS);
			}
			return codeLength;
		}
		
		throw new IOException("Error encoding CHOICE: No element of CHOICE was selected.");
	}

	@Override public int decode(InputStream is) throws IOException {
		return decode(is, true);
	}

	public int decode(InputStream is, boolean withTag) throws IOException {
		int tlvByteCount = 0;
		BerTag berTag = new BerTag();

		if (withTag) {
			tlvByteCount += tag.decodeAndCheck(is);
		}

		BerLength explicitTagLength = new BerLength();
		tlvByteCount += explicitTagLength.decode(is);
		tlvByteCount += berTag.decode(is);

		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.CONSTRUCTED, 0)) {
			authenticateClientOk = new AuthenticateClientOkEs11();
			tlvByteCount += authenticateClientOk.decode(is, false);
			tlvByteCount += explicitTagLength.readEocIfIndefinite(is);
			return tlvByteCount;
		}

		if (berTag.equals(BerTag.CONTEXT_CLASS, BerTag.PRIMITIVE, 1)) {
			authenticateClientError = new BerInteger();
			tlvByteCount += authenticateClientError.decode(is, false);
			tlvByteCount += explicitTagLength.readEocIfIndefinite(is);
			return tlvByteCount;
		}

		throw new IOException("Error decoding CHOICE: Tag " + berTag + " matched to no item.");
	}

	public void encodeAndSave(int encodingSizeGuess) throws IOException {
		ReverseByteArrayOutputStream reverseOS = new ReverseByteArrayOutputStream(encodingSizeGuess);
		encode(reverseOS, false);
		code = reverseOS.getArray();
	}

	@Override public String toString() {
		StringBuilder sb = new StringBuilder();
		appendAsString(sb, 0);
		return sb.toString();
	}

	public void appendAsString(StringBuilder sb, int indentLevel) {

		if (authenticateClientOk != null) {
			sb.append("authenticateClientOk: ");
			authenticateClientOk.appendAsString(sb, indentLevel + 1);
			return;
		}

		if (authenticateClientError != null) {
			sb.append("authenticateClientError: ").append(authenticateClientError);
			return;
		}

		sb.append("<none>");
	}

}

