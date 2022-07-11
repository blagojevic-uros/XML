<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:po="http://ftn.uns.ac.rs/vakcina/potvrda"
    xmlns:ct="http://ftn.uns.ac.rs/vakcina/tipovi"
    version="2.0">
    <xsl:template match="/">
        <html>
        	<head>
        		<style type="text/css">
        			body 
                    { 
                    	font-family: sans-serif;
                    }
        			#naslov {
        				font-size=24px;
        				font-weight:bold;
        				text-align:center;
        				margin-top: 10vh;
        			}
        			p 
                    {
                    	margin-left: 35vw;
                    }
                    ul li
                    {
                    	margin-left: 35vw;
                    }
                    table {
                    	border: 1px solid black;
                    	text-align:center;
                        font-family:serif;
                        width: 30%;
                        margin-left: 35vw;
                    }
                    th, td {
                    	border: 1px solid black;
                        text-align: center;
                        padding: 10px;
                    }
                    th {
                    	border: 1px solid black;
                        font-family: sans-serif;
                        font-weight="bold";
                    }
                    tr { border: 1px solid black; }
                    #potpis 
                    {
                    	border-top: 1px solid black;
                    	width: 10%;
                    	margin: 0px 0px 0px 54%;
                    	padding: 15px;
                    	text-align: center;
                    }
                </style>
        	</head>
        	<body>
        		<h1 id = "naslov">Potvrda o izvrsenoj vakcinaciji protiv COVID-19</h1>
        		<p style = "padding-top:10px">
                   Ime i prezime: <xsl:value-of select="//po:licni_podaci/po:ime_prezime/ct:ime/text()"/> <xsl:value-of select="//po:licni_podaci/po:ime_prezime/ct:prezime/text()"/>
                </p>
                
                <p style = "padding-top:10px;">
                	Datum rodjenja: <xsl:value-of select="//po:licni_podaci/po:datum_rodjenja/text()"/>
                </p>
                
                <p style = "padding-top:10px;">
                	Pol: <xsl:value-of select="//po:licni_podaci/po:datum_rodjenja/text()"/>
                </p>
                
                <p style = "padding-top:10px;">
                	JMBG: <xsl:value-of select="//po:licni_podaci/po:JMBG/text()"/>
                </p>
                
                <xsl:for-each select="//po:informacije_vakcinacije">
                	<p style = "padding-top:10px;">
                		Datum davanja <xsl:value-of select="po:broj_doze"/> doze i broj serije vakcine: <xsl:value-of select="concat(' ', po:datum_doze/text(), ' ', po:broj_serije/text())"/>
	                </p>
	                <p style = "padding-top:10px;">
	                	Zdravstvena ustanova koja vakcinise: <xsl:value-of select="po:zdravstena_ustanova/text()"/>
	                </p>
	                
	                <p style = "padding-top:10px;">
	                	Naziv vakcine: <xsl:value-of select="po:naziv_vakcine/text()"/>
	                </p>
	                
	                <p style = "padding-top:10px;">
	                	Datum izdavanja potvrde: <xsl:value-of select="po:datum_izdavanja_potvrde/text()"/>
	                </p>
                </xsl:for-each>
                
                
                <xsl:variable name="QR" select="//po:qr_kod/text()"/>
                <div style="width: 20vw; margin-right: 20vw; float:right">
                    <image src="data:image/jpeg;base64,{$QR}"/>
                </div>
        	</body>
        </html>
    </xsl:template>
</xsl:stylesheet>
