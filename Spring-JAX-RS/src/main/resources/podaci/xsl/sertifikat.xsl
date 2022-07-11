<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
                xmlns:se="http://ftn.uns.ac.rs/vakcina/sertifikat"
                xmlns:ct="http://ftn.uns.ac.rs/vakcina/tipovi"
                version="2.0">
    <xsl:template match="/">
        <html>
            <head>
                <title>Digitalni zeleni sertifikat</title>
                <style type="text/css">
                    #naslov {
                    font-size: 24px;
                    text-align: center;
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
                    .wrapper {
                    width: 70%;
                    margin: 0 auto;
                    }
                    #vakcinacija {
                    width:500px;
                    margin: 0 auto;
                    text-align: center;
                    border-top: 1px solid black;
                    width: 80vw;
                    padding-botton: 10px;

                    }
                    #gornje-slike{
                    overflow:auto;
                    }
                    #prva{
                    float:left;
                    }

                    #druga{
                    float:right;
                    }​
                </style>
            </head>
            <body>
                <div id = "gornje-slike">
                    <div id = "prva" style="width: 20vw; margin-left: 10vw;">

                    </div>
                    <xsl:variable name="QR" select="//se:QR/text()"/>
                    <div id = "druga" style="width: 20vw; margin-right: 10vw;">
                        <image src="data:image/jpeg;base64,{$QR}"/>
                    </div>
                </div>
                <div class='wrapper' style='text-align: center; font-size: 24px;'>
                    <div style='display: inline-block; vertical-align: top; margin-right: 5px; margin-botton: 5px;'>
                        <p><b>DIGITALNI ZELENI SERTIFIKAT</b></p>
                        <p>Potvrda o izvrsenoj vakcinaciji protiv</p>
                        <p>COVID-19 i rezultatima testiranja</p>
                        <p><b>DIGITAL GREEN CERTIFICATE</b></p>
                        <p>Certificate of vaccination against COVID-19
                            and test results</p>
                    </div>
                </div>
                <div style = "width: 20vw; margin-left: 10vw;">
                    <p><xsl:value-of select="//se:broj_sertifikata/text()"/></p>
                    <p><b>Datum i vreme izdavanja sertifikata / Certificate issuing date and time:</b></p>
                    <p><xsl:value-of select="//se:DatumDavanja/text()"/></p>
                    <p><b>Ime i prezime / Name and surname:</b></p>
                    <p><xsl:value-of select="concat(' ', //se:PunoIme/text())"/></p>
                    <p><b>Pol / Gender:</b></p>
                    <p><xsl:value-of select="//se:Pol/text()"/></p>
                    <p><b>JMBG / Personal No. / EBS:</b></p>
                    <p><xsl:value-of select="//se:JMBG/text()"/></p>
                    <p><b>Broj pasosa / Passport No.:</b></p>
                    <p><xsl:value-of select="//se:BrojPasosa/text()"/></p>
                </div>
                <h1 id = "vakcinacija">Vakcinacija / Vaccination</h1>
                <div class='wrapper' style='text-align: center;'>
                    <div style='display: inline-block; vertical-align:top; margin-right: 10px;'>
                        <p>
                            <b>Doza / Dose: 1 / 2</b>
                        </p>
                        <p>
                            <b>Tip / Type</b>
                        </p>
                        <p>
                            <xsl:value-of select="//se:Vakcinacija[1]/se:TipVakcine/text()"/>
                        </p>
                        <p>
                            <b>Proizvodjac i serija / Manufacturer and batch number:</b>
                        </p>
                        <p>
                            <xsl:value-of select="concat(' ', //se:Vakcinacija[1]/se:Proizvodjac/text(), ' ',  //se:Vakcinacija[1]/se:Serija/text())"/>
                        </p>
                        <p>
                            <b>Datum / Date:</b>
                            <xsl:value-of select="concat(' ', //se:Vakcinacija[1]/se:DatumDavanja/text())"/>
                        </p>
                        <p>
                            <b>Zdravstvena ustanova / Health care insitution:</b>
                        </p>
                        <p>
                            <xsl:value-of select="//se:Vakcinacija[1]/se:ZdravstvenaUstanova/text()"/>
                        </p>
                    </div>
                    <div style='display: inline-block; vertical-align: top; margin-left: 10px;'>
                        <p>
                            <b>Doza / Dose: 2 / 2</b>
                        </p>
                        <p>
                            <b>Tip / Type</b>
                        </p>
                        <p>
                            <xsl:value-of select="//se:Vakcinacija[2]/se:TipVakcine/text()"/>
                        </p>
                        <p>
                            <b>Proizvodjac i serija / Manufacturer and batch number:</b>
                        </p>
                        <p>
                            <xsl:value-of select="concat(' ', //se:Vakcinacija[2]/se:Proizvodjac/text(), ' ', //se:Vakcinacija[2]/se:Serija/text())"/>
                        </p>
                        <p>
                            <b>Datum / Date:</b>
                            <xsl:value-of select="concat(' ', //se:Vakcinacija[2]/se:DatumDavanja/text())"/>
                        </p>
                        <p>
                            <b>Zdravstvena ustanova / Health care insitution:</b>
                        </p>
                        <p>
                            <xsl:value-of select="//se:Vakcinacija[2]/se:ZdravstvenaUstanova/text()"/>
                        </p>
                    </div>
                </div>
                <table class='wrapper'>
                    <tr style="border-bottom: 1px solid #e7e9eb;">
                        <th>SARS-Co-2 RT Real-time PCR</th>
                        <th>SARS-CoV-2 Ag-RDT (Antigen Rapid Detection test)</th>
                        <th>SARS-CoV-2 RBD S-Protein Immunoglobulin G (IgG) test</th>
                    </tr>
                    <tr>
                        <td>
                            <b>Vrsta uzorka / Sample type:</b>
                        </td>
                        <td>
                            <b>Vrsta uzorka / Sample type:</b>
                        </td>
                        <td>
                            <b>Vrsta uzorka / Sample type:</b>
                        </td>
                    </tr>
                    <tr>
                        <td>N/A</td>
                        <td>N/A</td>
                        <td>N/A</td>
                    </tr>
                    <tr>
                        <td>
                            <b>Proizvodjac testa / Test manufacturer</b>
                        </td>
                        <td>
                            <b>Proizvodjac testa / Test manufacturer</b>
                        </td>
                        <td>
                            <b>Proizvodjac testa / Test manufacturer</b>
                        </td>
                    </tr>
                    <tr>
                        <td>N/A</td>
                        <td>N/A</td>
                        <td>N/A</td>
                    </tr>
                    <tr>
                        <td>
                            <b>Datum i vreme uzorkovanja / Date and time of sampling</b>
                        </td>
                        <td>
                            <b>Datum i vreme uzorkovanja / Date and time of sampling</b>
                        </td>
                        <td>
                            <b>Datum i vreme uzorkovanja / Date and time of sampling</b>
                        </td>
                    </tr>
                    <tr>
                        <td>N/A</td>
                        <td>N/A</td>
                        <td>N/A</td>
                    </tr>
                    <tr>
                        <td>
                            <b>Datum i vreme izdavanja rezultata / Date and time of result</b>
                        </td>
                        <td>
                            <b>Datum i vreme izdavanja rezultata / Date and time of result</b>
                        </td>
                        <td>
                            <b>Datum i vreme izdavanja rezultata / Date and time of result</b>
                        </td>
                    </tr>
                    <tr style="border-bottom: 1px solid black;">
                        <td>N/A</td>
                        <td>N/A</td>
                        <td>N/A</td>
                    </tr>
                    <tr style="background-color: #e7e9eb;">
                        <td>
                            <b>Rezultat / Result:</b>
                        </td>
                        <td>
                            <b>Rezultat / Result:</b>
                        </td>
                        <td>
                            <b>Rezultat / Result:</b>
                        </td>
                    </tr>
                    <tr style="background-color: #e7e9eb;">
                        <td>N/A</td>
                        <td>N/A</td>
                        <td>N/A</td>
                    </tr>
                    <tr style="background-color: #e7e9eb;">
                        <td>
                            <b>Laboratorija / Laboratory:</b>
                        </td>
                        <td>
                            <b>Laboratorija / Laboratory:</b>
                        </td>
                        <td>
                            <b>Laboratorija / Laboratory:</b>
                        </td>
                    </tr>
                    <tr style="background-color: #e7e9eb;">
                        <td>N/A</td>
                        <td>N/A</td>
                        <td>N/A</td>
                    </tr>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>