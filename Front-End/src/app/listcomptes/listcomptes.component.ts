import { Component, OnInit } from '@angular/core';
import { Client } from '../models/client';
import { Compte } from '../models/compte';
import { ServiceClientService } from '../services/service-client.service';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-listcomptes',
  templateUrl: './listcomptes.component.html',
  styleUrls: ['./listcomptes.component.css']
})
export class ListcomptesComponent implements OnInit {

  client:Client;
  listecomptes : Compte[];
  compteCourant :Compte;
  compteEpargne :Compte;
  
  constructor(private serviceClient:ServiceClientService, private activeRoute: ActivatedRoute) { }

  ngOnInit() { this.activeRoute.params.subscribe( (p) => {
    //console.log(p.id)
    this.serviceClient.getById(p.id).subscribe(data=>{
    console.log(data);
    this.client=data;
   console.log(this.client);
    })
    this.serviceClient.getCompteById(p.id).subscribe( (data :any) => {
    
    this.listecomptes= data
    //console.log(this.listecomptes)
    this.compteCourant= this.listecomptes[0];
    console.log(this.compteCourant.numeroCompte)
    if(this.listecomptes.length == 2){
      this.compteEpargne = this.listecomptes[1];
    }
    //console.log(this.listecomptes);
    //console.log(this.compteCourant);
    })
  })
  }

}
