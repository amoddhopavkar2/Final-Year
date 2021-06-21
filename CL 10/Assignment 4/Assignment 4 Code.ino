// Name - Amod Dhopavkar
// Roll No - 43304

int out_pin = 9;

void setup() {
  pinMode(out_pin, OUTPUT);
  pinMode(A0, INPUT);
  Serial.begin(9600);
}

void loop() {
  int inputLight = analogRead(A0);
  Serial.println(inputLight);
  
  if (inputLight < 450) {
    digitalWrite(out_pin, HIGH);
  }
  else {
    digitalWrite(out_pin, LOW);
  }
  
  delay(5);
}