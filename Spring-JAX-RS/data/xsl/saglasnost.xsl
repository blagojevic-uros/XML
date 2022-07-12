<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:sa="http://ftn.uns.ac.rs/vakcina/saglasnost"
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
        		<h1 id = "naslov">Saglasnost za sprovodjenje preporucene imunizacije</h1>
        		<p style = "padding-top:10px">
        		   <span style="font-weight:bold;">Drzavljantsvo</span>
                   <xsl:choose>
					 <xsl:when test="//sa:licni_podaci/sa:drzavljanstvo/sa:srpsko">
					  	<span style = "padding-top:10px;">
		                	Republika Srbija | <xsl:value-of select="//sa:licni_podaci/sa:drzavljanstvo/sa:srpsko/sa:JMBG/text()"/>
		                </span>
					 </xsl:when>
					 <xsl:when test="//sa:licni_podaci/sa:drzavljanstvo/sa:strano">
					  	<span style = "padding-top:10px;">
		                	<xsl:value-of select="//sa:licni_podaci/sa:drzavljanstvo/sa:strano/sa:naziv_drzavljanstva/text()"/> | <xsl:value-of select="//sa:licni_podaci/sa:drzavljanstvo/sa:strano/sa:broj_pasosa_ebs/text()"/>
		                </span>
					 </xsl:when>
					</xsl:choose>
                </p>
                
                <p style = "padding-top:10px;">
                	<span style="font-weight:bold;"> Prezime | </span>
                	<xsl:value-of select="//sa:licni_podaci/sa:prezime/text()"/>
                	
                	<span style="font-weight:bold;"> Ime | </span>
                	<xsl:value-of select="//sa:licni_podaci/sa:ime/text()"/>
                	
                	<span style="font-weight:bold;"> Ime roditelja | </span>
                	<xsl:value-of select="//sa:licni_podaci/sa:ime_roditelja/text()"/>
                </p>
                
                <p style = "padding-top:10px;">
                	<span style="font-weight:bold;"> Pol | </span>
                	<xsl:value-of select="//sa:licni_podaci/sa:pol/text()"/>
                	
                	<span style="font-weight:bold;"> Datum rodjenja | </span>
                	<xsl:value-of select="//sa:licni_podaci/sa:datum_rodjenja/text()"/>
                	
                	<span style="font-weight:bold;"> Mesto rodjenja | </span>
                	<xsl:value-of select="//sa:licni_podaci/sa:mesto_rodjenja/text()"/>
                </p>
                
                <p style = "padding-top:10px;">
                	<span style="font-weight:bold;"> Adresa | </span>
                	<xsl:value-of select="//sa:licni_podaci/sa:adresa/text()"/>
                	
                	<span style="font-weight:bold;"> Mesto/Naselje | </span>
                	<xsl:value-of select="//sa:licni_podaci/sa:mesto_naselje/text()"/>
                </p>
                
                <p style = "padding-top:10px;">
                	<span style="font-weight:bold;"> Opstina/Grad | </span>
                	<xsl:value-of select="//sa:licni_podaci/sa:opstina_grad/text()"/>
                	
                	<span style="font-weight:bold;"> Tel. fiksni | </span>
                	<xsl:value-of select="//sa:licni_podaci/sa:fiksni_broj/text()"/>
                </p>
                
                <p style = "padding-top:10px;">
                	<span style="font-weight:bold;"> Tel. mobilni | </span>
                	<xsl:value-of select="//sa:licni_podaci/sa:mobilni_broj/text()"/>
                	
                	<span style="font-weight:bold;"> Email | </span>
                	<xsl:value-of select="//sa:licni_podaci/sa:email/text()"/>
                </p>
                
                <p style = "padding-top:10px;">
                	<span style="font-weight:bold;"> Radni status : </span>
                	<xsl:value-of select="//sa:licni_podaci/sa:radni_status/text()"/>
                </p>
                
                <p style = "padding-top:10px;">
                	<span style="font-weight:bold;"> Zanimanje zaposlenog : </span>
                	<xsl:value-of select="//sa:licni_podaci/sa:zanimanje_zaposlenog/text()"/>
                </p>
                
                <p style = "padding-top:10px;">
                	<span style="font-weight:bold;"> Naziv ustanove socijalne zastite |</span>
                	<xsl:value-of select="//sa:evidencija_o_vakcinaciji/sa:zdravstvena_ustanova/text()"/>
                	
                	<span style="font-weight:bold;"> Mesto/Naselje | </span>
                	<xsl:value-of select="//sa:evidencija_o_vakcinaciji/sa:opstina_grad/text()"/>
                </p>
                
                <p style = "padding-top:10px;">
                	<span style="font-weight:bold;"> Naziv imunoloskog leka : </span>
                	<xsl:value-of select="//sa:evidencija_o_vakcinaciji/sa:naziv_leka/text()"/>
                </p>
                
                <p style = "padding-top:30px;">
	                Datum izdavanja: 
	                <u><xsl:value-of select="//sa:datum_davanja/text()"/></u>
	                godine.	
                </p>
                <p id="potpis">Potpis</p>
                
                <p style = "padding-top:10px;">
                	<span style="font-weight:bold;">#####################################################################################################</span>
                </p>
                
                <h1 id = "naslov">Evidencija o vakcinaciji protiv COVID-19</h1>
                
                <p style = "padding-top:10px;">
                	<span style="font-weight:bold;"> Zdravstvena ustanova | </span>
                	<xsl:value-of select="//sa:evidencija_o_vakcinaciji/sa:zdravstvena_ustanova/text()"/>
                	
                	<span style="font-weight:bold;"> Vakcinacijski punkt | </span>
                	<xsl:value-of select="//sa:evidencija_o_vakcinaciji/sa:vakcinijski_punkt/text()"/>
                </p>
                
                <p style = "padding-top:10px;">
                	<span style="font-weight:bold;"> Ime lekara | </span>
                	<xsl:value-of select="//sa:evidencija_o_vakcinaciji/sa:lekar/sa:ime/text()"/>

                	<span style="font-weight:bold;"> Prezime lekara | </span>
                	<xsl:value-of select="//sa:evidencija_o_vakcinaciji/sa:lekar/sa:prezime/text()"/>
                </p>
                
                <p style = "padding-top:10px;">
                	<span style="font-weight:bold;"> Broj telefona lekara : </span>
                	<xsl:value-of select="//sa:evidencija_o_vakcinaciji/sa:lekar/sa:broj_telefona/text()"/>
                </p>
       			
       			<table>
                    <tr style="border-bottom: 1px solid #e7e9eb;">
                        <th>Naziv vakcine</th>
                        <th>Datum davanja vakcine (V1 i V2)</th>
                        <th>Nacin davanja vakcine</th>
                        <th>Ekstremitet</th>
                        <th>Serija vakcine (lot)</th>
                        <th>Proizvodjac</th>
                        <th>Nezeljena reakcija</th>
                        <th>Potpis lekara</th>
                    </tr>
                    <xsl:for-each select="//sa:evidencija_o_vakcinaciji/sa:tabela_vakcinisanja/sa:vakcinisanje">
                    	<tr>
	                        <td>
	                            <xsl:value-of select="sa:naziv_vakcine/text()"/>
	                        </td>
	                        <td>
	                            <xsl:value-of select="sa:datum_davanja/text()"/>
	                        </td>
	                        <td>
	                            IM
	                        </td>
	                        <td>
	                            <xsl:value-of select="sa:ekstremitet/text()"/>
	                        </td>
	                        <td>
	                            <xsl:value-of select="sa:serija_vakcine/text()"/>
	                        </td>
	                        <td>
	                            <xsl:value-of select="sa:proizvodjac/text()"/>
	                        </td>
	                        <td>
	                            <xsl:value-of select="sa:nezeljena_reakcija/text()"/>
	                        </td>
                        	<td></td>
                    	</tr>
                    </xsl:for-each>
                    <tr>
                        <td colspan = "8">
                            <div style = "float: left">Privremene kontraindikacije</div>
                            <br/>
                            <div style = "float: left">(Datum utvrdjivanja i dijagnoza)</div>
                            <div style = "float: right">
                            	<xsl:value-of select="//sa:evidencija_o_vakcinaciji/sa:privremene_kontraindikacije/sa:datum/text()"/>
                            </div>
                            <br/>
                            <div style = "float: right">
                            	<xsl:value-of select="//sa:evidencija_o_vakcinaciji/sa:privremene_kontraindikacije/sa:dijagnoza/text()"/>
                            </div>
                        </td>
                    </tr>
                </table>
        	</body>
        </html>
    </xsl:template>
</xsl:stylesheet>
