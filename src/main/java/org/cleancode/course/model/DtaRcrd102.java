package org.cleancode.course.model;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class DtaRcrd102 {
    private Timestamp m_genymdhms;
    private Timestamp m_modymdhms;
    private final String m_pszqintString = "102";
    private String m_rateString;
    private String m_titleString;
    private String m_contentString;
}
