package com.example.myimadassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    //List of historical figures with the ages they died
    enum class  HistoricalFigures(val age: Int, val description: String) {
        Figure_1(20,"Aaliyah, who was an American singer and actress"),
        Figure_2(24,"James Dean, who was an American actor and a remarkable teenage icon of disillusionment and rebellion"),
        Figure_3(28,"Heath Ledger, who was an Australian actor known for his roles in films such as Brokeback Mountain, The Dark Knight and A Knight's Tale"),
        Figure_4(30,"Emperor Neero, was the final emperor of the Julio-Claudian dynasty"),
        Figure_5(32,"Alexander the Great, who  was a king of the ancient Greek kingdom of Macedon and a member of the Argead dynasty"),
        Figure_6(36,"Princess Diana,who was the Princess of Wales and the first Englishwoman to marry an heir to the throne for 300 years"),
        Figure_7(40,"Cleopatra VII, who was the last active ruler of the Ptolemaic Kingdom of Egypt"),
        Figure_8(44,"Alexander Hamilton, who was one of the Founding Fathers of the United States"),
        Figure_9(48,"Vincent van Gogh, who was a Dutch Post-Impressionist painter who is among the most famous and influential figures in the history of Western art"),
        Figure_10(52,"William Shakespeare, who was an English playwright, poet, and actor , he is regarded as the greatest writer in the English language"),
        Figure_11(56,"Julius Caesar, who was a Roman general and statesman who led the Roman armies in the Gallic Wars before defeating his political rival Pompey in a civil war"),
        Figure_13(60,"Theodore Roosevelt, who was the 26th President of the United States"),
        Figure_14(65,"Genghis Khan, who was the founder and first Great Khan of the Mongol Empire , Later on, it grew to become history's greatest contiguous empire"),
        Figure_15(67,"Leonardo da Vinci, who  was An inventor, painter, sculptor, architect, scientist, musician, mathematician, engineer, writer, historian, cartographer and capable of many more"),
        Figure_16(71,"Socrates, who was an Athens-born Greek philosopher who is recognized as the father of Western philosophy"),
        Figure_17(76,"Albert Einstein, who was a theoretical physicist of German descent who is regarded as one of history's finest and most significant scientists"),
        Figure_18(78,"Mahatma Ghandi, who was an Indian lawyer, political ethicist, and anti-colonialist who led the successful effort to free India from British control by using nonviolent resistance"),
        Figure_19(80,"Charles Darwin, who was an English scientist, geologist, and naturalist who is most known for his theory of natural selection, which he developed and contributed to the field of evolution"),
        Figure_20(84,"Thomas Edison, who was a businessman and inventor from America, he created numerous gadgets in industries including the production of electric power"),
        Figure_21(88,"Mary Teresa a.k.a Mother Teresa, who was the founder of the Missionaries of Charity and a Catholic nun of Albanian and Indian descent"),
        Figure_22(90,"Winston Churchill was Prime Minister of the United Kingdom twice, from 1951 to 1955 and from 1940 to 1945 during World War II, was Winston Churchill, a British leader, writer, and soldier"),
        Figure_23(92,"Rosa Parks, who was a Civil Rights Movement American Activist Known for Her Crucial Part in the Montgomery Bus Boycott"),
        Figure_24(95,"Nelson Mandela, who was a political activist, philanthropist, and anti-apartheid revolutionary from South Africa who then became the president for 5 years, he played an impotant role to end apartheid"),
        Figure_25(100,"Bob Hope, who was a British-American stand-up comedian, vaudeville performer, actor, singer, dancer, and author who gained notoriety for his work with the USO during World War II and other contributions to entertainment")
}


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Declaring layout component variables
        val btnAnswer = findViewById<Button>(R.id.btnAnswer)
        val btnClear = findViewById<Button>(R.id.btnClear)
        val editNumberAge = findViewById<EditText>(R.id.editNumberAge)
        val displayResult = findViewById<TextView>(R.id.displayResult)


        //Programming the generate button
        btnAnswer.setOnClickListener {
            val birthYear = editNumberAge.text.toString().toInt()
            if (birthYear!= null && birthYear in 20..100){

                //Grabbing the values of the ages in the list of Historical Figures
                val figuresAge = HistoricalFigures.values().map { it.age }

                val description = when (birthYear) {

                    // This statement will be run if the age matches exactly the year of the historical figures death age
                    in figuresAge -> {
                        val description = HistoricalFigures.values().find { it.age == birthYear }
                        listOf( "$birthYear: ${description?.description ?: "description"} ")

                    }

                    // This statement will be run if the age is two years after the year of the historical figures death age
                    in figuresAge.map { it + 2 } -> {
                        val description = HistoricalFigures.values().find { it.age == birthYear - 2 }
                        listOf( "Your age is two years after the historical figures age of " +
                                "${description?.description ?: "description"} ")




                    }
                    //This statement will be run if age is two years before the year of the historical figures death age
                    in figuresAge.map { it - 2 } -> {
                        val description = HistoricalFigures.values().find { it.age == birthYear + 2 }
                        listOf("Your age is two years before the historical figures age of "  +
                                "${description?.description ?: "description"} ")



                    }
                    // This statement will run if age is not the same or close to historical event
                    else -> listOf("No historical figure known for $birthYear ")
                }

                displayResult.text = description.joinToString("\n")

            }else {
                displayResult.text = "No historical figure has been found from the input of your age"
            }

        }
        //Programming the clear button
        btnClear.setOnClickListener {
            editNumberAge.text.clear()
            displayResult.text = ""
        }










    }
}