import 'package:flutter/material.dart';

void main() {
  runApp(MyApp());
}

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        body: Container(
          color: Colors.green,
          child: Center(
            child: Column(
              mainAxisAlignment: MainAxisAlignment.center,
              children: [
                Container(
                  color: Colors.grey,
                  padding: EdgeInsets.all(16.0),
                  child: Column(
                    crossAxisAlignment: CrossAxisAlignment.start,
                    children: [
                      Text(
                        'Professor responsável: Claudiany',
                        style: TextStyle(
                          color: Colors.white,
                          fontSize: 18.0,
                          fontWeight: FontWeight.bold,
                        ),
                      ),
                      Text(
                        'Horário: 19:00 ~ 22:00',
                        style: TextStyle(
                          color: Colors.white,
                          fontSize: 18.0,
                          fontWeight: FontWeight.bold,
                        ),
                      ),
                      Text(
                        'Dia: 14/06/2023',
                        style: TextStyle(
                          color: Colors.white,
                          fontSize: 18.0,
                          fontWeight: FontWeight.bold,
                        ),
                      ),
                    ],
                  ),
                ),
                SizedBox(height: 650.0),
                Row(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: [
                    SizedBox(
                      height: 50.0,
                      width: 200.0,
                      child: ElevatedButton(
                        onPressed: () {
                          Navigator.pushNamed(context, "loginScreen");
                        },
                        child: Text('Voltar'),
                      ),
                    ),
                    SizedBox(width: 16.0),
                    SizedBox(
                      height: 50.0,
                      width: 200.0,
                      child: ElevatedButton(
                        onPressed: () {
                          Navigator.pushNamed(context, "reserva");
                        },
                        child: Text('Agendar'),
                      ),
                    ),
                  ],
                ),
                SizedBox(height: 16.0), // Espaço entre as duas fileiras de botões
                Row(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: [
                    SizedBox(
                      height: 50.0,
                      width: 200.0,
                      child: ElevatedButton(
                        onPressed: () {
                          // Ação para o terceiro botão
                        },
                        style: ButtonStyle(
                          backgroundColor:
                              MaterialStateProperty.all<Color>(Colors.grey),
                        ),
                        child: Text('Modificar'),
                      ),
                    ),
                    SizedBox(width: 16.0),
                    SizedBox(
                      height: 50.0,
                      width: 200.0,
                      child: ElevatedButton(
                        onPressed: () {
                          // Ação para o quarto botão
                        },
                        style: ButtonStyle(
                          backgroundColor:
                              MaterialStateProperty.all<Color>(Colors.red),
                        ),
                        child: Text('Deletar'),
                      ),
                    ),
                  ],
                ),
                SizedBox(height: 16.0), // Espaço entre os botões e o texto
              ],
            ),
          ),
        ),
      ),
    );
  }
}
