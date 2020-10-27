package com.example.calculadora;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button boton_9, boton_8, boton_7, boton_6, boton_5, boton_4, boton_3, boton_2, boton_1, boton_0;
    Button boton_borra, boton_suma, boton_resta, boton_muliplica, boton_divide, boton_igual;
    String almacena_operacion = "";
    String memoria = "";
    Float resultado = 0.0F;
    TextView visor;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        visor = (TextView) findViewById(R.id.Visor);
        boton_9 = (Button) findViewById(R.id.boton_9);
        boton_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                escribe("9");
            }
        });
        boton_8 = (Button) findViewById(R.id.boton_8);
        boton_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                escribe("8");
            }
        });
        boton_7 = (Button) findViewById(R.id.boton_7);
        boton_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                escribe("7");
            }
        });
        boton_6 = (Button) findViewById(R.id.boton_6);
        boton_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                escribe("6");
            }
        });
        boton_5 = (Button) findViewById(R.id.boton_5);
        boton_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                escribe("5");
            }
        });
        boton_4 = (Button) findViewById(R.id.boton_4);
        boton_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                escribe("4");
            }
        });
        boton_3 = (Button) findViewById(R.id.boton_3);
        boton_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                escribe("3");
            }
        });
        boton_2 = (Button) findViewById(R.id.boton_2);
        boton_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                escribe("2");
            }
        });
        boton_1 = (Button) findViewById(R.id.boton_1);
        boton_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                escribe("1");
            }
        });
        boton_0 = (Button) findViewById(R.id.boton_0);
        boton_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                escribe("0");
            }
        });

        boton_suma = (Button) findViewById(R.id.boton_suma);
        boton_resta = (Button) findViewById(R.id.boton_resta);
        boton_divide = (Button) findViewById(R.id.boton_divide);
        boton_muliplica = (Button) findViewById(R.id.boton_multiplica);

        boton_igual = (Button) findViewById(R.id.boton_igual);
        boton_borra = (Button) findViewById(R.id.boton_borra);

        boton_suma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operacion("suma");
            }
        });
        boton_muliplica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operacion("multiplicación");
            }
        });
        boton_resta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operacion("resta");
            }
        });
        boton_divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operacion("división");
            }
        });
        boton_igual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                visor.setText(calcula());
                almacena_operacion = "fin";
                memoria = "";
            }
        });


        boton_borra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                almacena_operacion = "";
                memoria = "";

                visor.setText("0");
            }
        });


    }

    private String calcula() {
        if (almacena_operacion.equals("suma"))
            resultado = Float.parseFloat(memoria) + Float.parseFloat(visor.getText().toString());
        if (almacena_operacion.equals("resta"))
            resultado = Float.parseFloat(memoria) - Float.parseFloat(visor.getText().toString());
        if (almacena_operacion.equals("multiplicación"))
            resultado = Float.parseFloat(memoria) * Float.parseFloat(visor.getText().toString());
        if (almacena_operacion.equals("división"))
            resultado = Float.parseFloat(memoria) / Float.parseFloat(visor.getText().toString());
        almacena_operacion = "fin";
        return resultado.toString();
    }

    private void escribe(String numero) {
        if (visor.getText().equals("0") || almacena_operacion.equals("fin")) {
            visor.setText(numero);
            if (almacena_operacion.equals("fin")){ almacena_operacion="";}
        }else
            visor.append(numero);

    }

    private void operacion(String operacion) {
        if (almacena_operacion.equals("") || almacena_operacion.equals("fin")) {
            almacena_operacion = operacion;
            memoria = visor.getText().toString();
        }else {
            memoria = calcula();
        }
            almacena_operacion = operacion;
            visor.setText("0");


    }
}
