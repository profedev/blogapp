import { Component, OnInit } from '@angular/core';
import { DataService } from '../services/data.service';

@Component({
  selector: 'app-subsecciones',
  templateUrl: './subsecciones.component.html',
  styleUrls: ['./subsecciones.component.css']
})
export class SubseccionesComponent implements OnInit {

  //Defino atributos de la clase
  parrafo1?:string;
  visible?:string;
  articulos?:any;
  

  constructor(private data:DataService) { }

  ngOnInit(): void {
    this.parrafo1 = 'Donzxzec ut librero sed accu vehicula ultricies a non tortor. Lorem ipsum dolor sit amet, consectetur adipisicing elit. Aenean ut gravida lorem. Ut turpis felis, pulvinar a semper sed, adipiscing id dolor. Pelientesque auctor nisi id magna consequat sagittis. Curabitur dapibus, enim sit amet elit pharetra tincidunt feugiat nist imperdiet. Ut convallis libero in urna ultrices accumsan. Donec sed odio eros.';
    this.visible = 'none';
    //Recupera los datos del servicio y guarda el Json recibido en el atributo otrasSubsecciones
    this.data.getDataFromJson().subscribe(datos => {this.articulos = datos});
  }

  //Muestra el TextArea
  mostrarTextArea(){
    this.visible = 'block';
  }

  //Oculta el TextArea
  ocultarTextArea(){
    this.visible = 'none';
  }


}
