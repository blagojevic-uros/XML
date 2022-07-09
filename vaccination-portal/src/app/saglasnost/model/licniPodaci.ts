import { Adresa } from "./adresa";

export interface LicniPodaci{
    prezime : string;
    ime: string;
    imeRoditelja: string;
    pol: string;
    datumRodjenja: Date;
    mestoRodjenja: string;
    adresa: Adresa;
    fiksniBroj: string;
    mobilniBroj: string;
    email: string;
    radniStatus: string;
    zanimanjeZaposlenog: string;
}