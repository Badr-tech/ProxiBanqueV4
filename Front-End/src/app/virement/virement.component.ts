import { Component, OnInit } from '@angular/core';
import { FormBuilder } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { SeviceCompteService } from '../services/sevice-compte.service';
import { Compte } from '../models/compte';

@Component({
  selector: 'app-virement',
  templateUrl: './virement.component.html',
  styleUrls: ['./virement.component.css']
})
export class VirementComponent implements OnInit {
   idCompte:number
   compte:Compte
  constructor(private fb: FormBuilder, private activeRoute: ActivatedRoute, private router: Router, private serviceCompte: SeviceCompteService) { }

  ngOnInit() {
    this.activeRoute.params.subscribe(p=>{
      this.idCompte=p.id
      console.log(this.idCompte)
    })
    this.serviceCompte.getCompteById(this.idCompte).subscribe((data:any)=>{
      this.compte=data
      console.log(this.compte)
    })
  }
  passerVirement(data){
    console.log(data)
    let c1=data.value.debiteur
    let c2=data.value.crediteur
    let mtn=data.value.montant
    this.serviceCompte.virement(c1,c2,mtn).subscribe(p=>{
      console.log(p)
    })

  }
}
