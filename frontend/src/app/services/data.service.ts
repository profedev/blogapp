import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  constructor(private http:HttpClient) { }

  //Devuelve los datos del archivo json
  getDataFromJson():Observable<any>{
    
    let uri:string;

    //Archivo json local
    //uri =  '../assets/data/subsecciones.json';

    //Backend local
    uri = 'http://localhost:8080/api/getArticulos';    
       
    return this.http.get(uri);
  }

}
