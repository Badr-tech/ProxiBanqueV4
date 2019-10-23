import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/environments/environment';
import { Compte } from '../models/compte';

@Injectable({
  providedIn: 'root'
})
export class SeviceCompteService {

  constructor(private httpClient:HttpClient) { }


  getCompteById(id:number){
   return this.httpClient.get<Compte>(environment.serverUrl+"comptes/"+id)
  }
  virement(compte1,compte2,montant){
    return this.httpClient.get(environment.serverUrl+"virements/virement/"+compte1+"/"+compte2+"/"+montant)
  }
}
