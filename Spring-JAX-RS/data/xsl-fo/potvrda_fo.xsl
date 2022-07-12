<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:fo="http://www.w3.org/1999/XSL/Format"
    xmlns:po="http://ftn.uns.ac.rs/vakcina/potvrda"
    xmlns:ct="http://ftn.uns.ac.rs/vakcina/tipovi"
    version="2.0">
    <xsl:template match="/">
        <fo:root>
            <fo:layout-master-set>
                <fo:simple-page-master master-name="potvrda-page">
                    <fo:region-body margin="0.75in"/>
                </fo:simple-page-master>
            </fo:layout-master-set>

            <fo:page-sequence master-reference="potvrda-page">
                <fo:flow flow-name="xsl-region-body">
                    <fo:block text-align="center" font-family="sans-serif" font-size="24px" font-weight="bold" padding="10px">
                        Potvrda o izvrsenoj vakcinaciji protiv COVID-19
                    </fo:block>
                    <fo:block font-size="13px" padding="10px">
                        	 <fo:inline>
                        	 	Ime i prezime:
                        	 </fo:inline>
                            <fo:inline>
                                <xsl:value-of select="concat(' ', //po:licni_podaci/po:ime_prezime/ct:ime/text(), ' ', //po:licni_podaci/po:ime_prezime/ct:ime/text())"/>
                            </fo:inline>
                    </fo:block>

                    <fo:block font-size="13px" padding="10px">
                        	 <fo:inline>
                        	 	Datum rodjenja:
                        	 </fo:inline>
                            <fo:inline>
                                <xsl:value-of select="//po:licni_podaci/po:datum_rodjenja/text()"/>
                            </fo:inline>
                    </fo:block>

                    <fo:block font-size="13px" padding="10px">
                        	 <fo:inline>
                        	 	Pol:
                        	 </fo:inline>
                            <fo:inline>
                                <xsl:value-of select="//po:licni_podaci/po:pol/text()"/>
                            </fo:inline>
                    </fo:block>

                    <fo:block font-size="13px" padding="10px">
                        	 <fo:inline>
                        	    JMBG:
                        	 </fo:inline>
                            <fo:block>
                                <xsl:value-of select="//po:licni_podaci/po:JMBG/text()"/>
                            </fo:block>
                    </fo:block>

                    <xsl:for-each select="//po:informacije_vakcinacije">
                    	<fo:block font-size="13px" padding="10px">
                        	 <fo:inline>
                        	    Datum davanja <xsl:value-of select="//po:broj_doze"/> doze i broj serije vakcine:
                        	 </fo:inline>
                            <fo:block>
                                <xsl:value-of select="concat(' ', //po:datum_izdavanja_potvrde/text(), ' ', //po:broj_serije/text())"/>
                            </fo:block>
                    </fo:block>
                    </xsl:for-each>

                    <fo:block font-size="13px" padding="10px">
                        	 <fo:inline>
                        	    Naziv vakcine:
                        	 </fo:inline>
                            <fo:block>
                                <xsl:value-of select="//po:naziv_vakcine/text()"/>
                            </fo:block>
                    </fo:block>

                    <fo:block font-size="13px" padding="10px">
                        	 <fo:inline>
                        	    Datum izdavanja potvrde:
                        	 </fo:inline>
                            <fo:block>
                                <xsl:value-of select="//po:datum_izdavanja_potvrde/text()"/>
                            </fo:block>
                    </fo:block>

                    <fo:block-container width="25%" left="80%" top="8in" position="absolute">
                            <fo:block>
                                <xsl:variable name="QR" select="//po:qr_kod/text()"/>
                                <fo:external-graphic src="url('data:image/jpeg;base64,{$QR}')"/>
                            </fo:block>
                    </fo:block-container>
                </fo:flow>
            </fo:page-sequence>
        </fo:root>
    </xsl:template>
</xsl:stylesheet>
