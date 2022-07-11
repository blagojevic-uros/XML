<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:fo="http://www.w3.org/1999/XSL/Format"
    xmlns:in="http://ftn.uns.ac.rs/vakcina/interesovanje"
    version="2.0">
    <xsl:template match="/">
        <fo:root>
            <fo:layout-master-set>
                <fo:simple-page-master master-name="interesovanje-page">
                    <fo:region-body margin="0.75in"/>
                </fo:simple-page-master>
            </fo:layout-master-set>

            <fo:page-sequence master-reference="interesovanje-page">
                <fo:flow flow-name="xsl-region-body">
                    <fo:block text-align="center" font-family="sans-serif" font-size="24px" font-weight="bold" padding="10px">
                        Iskazivanje interesovanja za vakcinisanje protiv COVID-19
                    </fo:block>
                    <fo:block font-size="13px" padding="10px">
                        	 <fo:inline font-weight="bold">
                        	 	Gradjanin je:
                        	 </fo:inline>
                            <fo:inline>
                                <xsl:value-of select="//in:licni_podaci/in:drzavljanstvo/text()"/>
                            </fo:inline>
                    </fo:block>
                    
                    <fo:block font-size="13px" padding="10px">
                        	 <fo:inline font-weight="bold">
                        	    JMBG:
                        	 </fo:inline>
                            <fo:block  padding-left="50px">
                                <xsl:value-of select="//in:licni_podaci/in:JMBG/text()"/>
                            </fo:block>
                    </fo:block>
                    
                    <fo:block font-size="13px" padding="10px">
                        	 <fo:inline font-weight="bold">
                        	    Ime:
                        	 </fo:inline>
                            <fo:block padding-left="50px">
                                <xsl:value-of select="//in:licni_podaci/in:ime/text()"/>
                            </fo:block>
                    </fo:block>
                    
                    <fo:block font-size="13px" padding="10px">
                        	 <fo:inline font-weight="bold">
                        	    Prezime:
                        	 </fo:inline>
                            <fo:block padding-left="50px">
                                <xsl:value-of select="//in:licni_podaci/in:prezime/text()"/>
                            </fo:block>
                    </fo:block>
                    
                    <fo:block font-size="13px" padding="10px">
                        	 <fo:inline font-weight="bold">
                        	    Adresa elektronske poste:
                        	 </fo:inline>
                            <fo:block padding-left="50px">
                                <xsl:value-of select="//in:licni_podaci/in:email/text()"/>
                            </fo:block>
                    </fo:block>
                    
                    <fo:block font-size="13px" padding="10px">
                        	 <fo:inline font-weight="bold">
                        	    Broj mobilnog telefona:
                        	 </fo:inline>
                            <fo:block padding-left="50px">
                                <xsl:value-of select="//in:licni_podaci/in:mobilni_telefon/text()"/>
                            </fo:block>
                    </fo:block>
                    
                    <fo:block font-size="13px" padding="10px">
                        	 <fo:inline font-weight="bold">
                        	    Broj fiksnog telefona:
                        	 </fo:inline>
                            <fo:block padding-left="50px">
                                <xsl:value-of select="//in:licni_podaci/in:fiksni_telefon/text()"/>
                            </fo:block>
                    </fo:block>
                    
<!--                    <fo:block font-size="13px" padding="10px">-->
<!--                        	 <fo:inline font-weight="bold">-->
<!--                        	    Broj fiksnog telefona:-->
<!--                        	 </fo:inline>-->
<!--                            <fo:block padding-left="50px">-->
<!--                                <xsl:value-of select="//in:licni_podaci/in:fiksni_telefon/text()"/>-->
<!--                            </fo:block>-->
<!--                    </fo:block>-->
                    
                    <fo:block font-size="13px" padding="10px">
                        	 <fo:inline font-weight="bold">
                        	    Opstina primanja:
                        	 </fo:inline>
                            <fo:block padding-left="50px">
                                <xsl:value-of select="//in:lokacija_vakcinisanja/text()"/>
                            </fo:block>
                    </fo:block>
                    
                    <fo:block font-size="13px" padding="10px">
                        	 <fo:inline font-weight="bold">
                        	    Tip vakcina:
                        	 </fo:inline>
                            <fo:block padding-left="50px">
                                <xsl:value-of select="//in:tip_vakcine/text()"/>
                            </fo:block>
                    </fo:block>
                    
                    <fo:block font-size="13px" padding="10px">
                        	 <fo:inline font-weight="bold">
                        	    Davalac krvi:
                        	 </fo:inline>
                            <fo:block padding-left="50px">
                                <xsl:choose>
									 <xsl:when test="//in:davalac_krvi/text()='true'">
									  	<p style = "padding-top:10px;">
						                	Da
						                </p>
									 </xsl:when>
									 <xsl:when test="//in:davalac_krvi/text()='false'">
									  	<p style = "padding-top:10px;">
						                	Ne
						                </p>
									 </xsl:when>
								</xsl:choose>
                            </fo:block>
                    </fo:block>
                    
       					<fo:block-container>
       						<fo:block font-size="13px">
	                            <fo:inline>
	                                Datum izdavanja: 
	                                <fo:inline text-decoration="underline">
	                                   <xsl:value-of select="//in:datum/text()"/>
	                                </fo:inline>
	                                godine
	                            </fo:inline>
                        	</fo:block>
	                        <fo:block-container width="40%" left="60%" top="0in" position="absolute">
	                        	<fo:block text-align = "center">
	                        		<fo:leader leader-pattern="rule" leader-length.minimum="2.5in" leader-length.optimum="2in" leader-length.maximum="3in"/>
	                        		<fo:block>Potpis</fo:block>
	                        	</fo:block>
	                        </fo:block-container>
                    	</fo:block-container>
                    	
                </fo:flow>
            </fo:page-sequence>
        </fo:root>
    </xsl:template>
</xsl:stylesheet>
