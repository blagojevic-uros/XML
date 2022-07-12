<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:fo="http://www.w3.org/1999/XSL/Format"
				xmlns:za="http://ftn.uns.ac.rs/vakcina/zahtev"
				xmlns:ct="http://ftn.uns.ac.rs/vakcina/tipovi"
    version="2.0">
    <xsl:template match="/">
        <fo:root>
            <fo:layout-master-set>
                <fo:simple-page-master master-name="zahtev-page">
                    <fo:region-body margin="0.75in"/>
                </fo:simple-page-master>
            </fo:layout-master-set>

            <fo:page-sequence master-reference="zahtev-page">
                <fo:flow flow-name="xsl-region-body">
                    <fo:block text-align="center" font-family="sans-serif" font-size="18px" font-weight="bold" padding="10px">
                        ZAHTEV
                    </fo:block>
					<fo:block text-align="center" font-family="sans-serif" font-size="18px" font-weight="bold" padding="10px">
                        za izdavanje digitalnog zelenog sertifikata
                    </fo:block>
					<fo:block text-align="left" font-family="sans-serif" font-size="12px" padding="10px">
                        U skladu sa odredbom Republike Srbije o izdavanju digitalnog zelenog sertifikata kao potvrde o izvršenoj vakcinaciji protiv COVID-19, rezultatima testiranja na zaraznu bolest SARS-CoV-2 ili oporavku od bolesti COVID-19,podnosim zahtev za izdavanje digitalnog zelenog sertifikata.
                    </fo:block>
					<fo:block>
       					<fo:block-container>
							<fo:block font-size="12px">
	                            <fo:inline>
	                                Ime i prezime:
	                                <fo:inline text-decoration="underline">
	                                    <xsl:value-of select="//za:licni_podaci/za:ime_prezime/ct:ime/text()"/>
										<xsl:value-of select="//za:licni_podaci/za:ime_prezime/ct:prezime/text()"/>
	                                </fo:inline>
	                            </fo:inline>
							</fo:block>
							<fo:block font-size="12px">
								<fo:inline>
	                                Datum rodjenja:
	                                <fo:inline text-decoration="underline">
	                                    <xsl:value-of select="//za:licni_podaci/za:datum_rodjenja/text()"/>
	                                </fo:inline>
	                            </fo:inline>
							</fo:block>
							<fo:block font-size="12px">
								<fo:inline>
	                                Pol:
	                                <fo:inline text-decoration="underline">
	                                    <xsl:value-of select="//za:licni_podaci/za:pol/text()"/>
	                                </fo:inline>
	                            </fo:inline>
							</fo:block>
							<fo:block font-size="12px">
								<fo:inline>
	                                Jedinstveni maticni broj gradjanina:
	                                <fo:inline text-decoration="underline">
	                                    <xsl:value-of select="//za:licni_podaci/za:JMBG/text()"/>
	                                </fo:inline>
	                            </fo:inline>
							</fo:block>
							<fo:block font-size="12px">
								<fo:inline>
	                                Broj pasosa:
	                                <fo:inline text-decoration="underline">
	                                    <xsl:value-of select="//za:licni_podaci/za:broj_pasosa/text()"/>
	                                </fo:inline>
	                            </fo:inline>
							</fo:block>
							<fo:block font-size="12px">
								<fo:inline>
	                                Razlog podnosenja zahteva:
	                                <fo:inline text-decoration="underline">
	                                    <xsl:value-of select="//za:razlog_za_zahtev/text()" />
	                                </fo:inline>
	                            </fo:inline>
                        	</fo:block>
       						<fo:block font-size="12px">
	                            <fo:inline>
	                                Datum podnosenja: 
	                                <fo:inline text-decoration="underline">
	                                    <xsl:value-of select="//za:datum_zahteva"/>
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
 					</fo:block>
                </fo:flow>
            </fo:page-sequence>
        </fo:root>
    </xsl:template>
</xsl:stylesheet>
