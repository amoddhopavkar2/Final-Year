// Name - Amod Dhopavkar
// Roll No - 43304

#include <LiquidCrystal.h>
LiquidCrystal lcd(13,12,5,4,3,2);
void setup() {
// set up the LCD's number of columns and rows:
  lcd.begin(16, 2);
  // Print a message to the LCD.
  lcd.print("Roll No - 43304");
  lcd.setCursor(0,1);
  lcd.print("Name - Amod Dhopavkar");
  delay(1000);
}

void loop() {
  for (int i = 0; i < 21; i++) {
    // scroll one position left:
    lcd.scrollDisplayLeft();
    // wait a bit:
    delay(250);
  }

  // scroll 31 positions (string length + display length) to the right
  // to move it offscreen right:
  for (int i = 0; i < 37; i++) {
    // scroll one position right:
    lcd.scrollDisplayRight();
    // wait a bit:
    delay(250);
  }

  // scroll 16 positions (display length + string length) to the left
  // to move it back to center:
  for (int i= 0; i< 16; i++) {
    // scroll one position left:
    lcd.scrollDisplayLeft();
    // wait a bit:
    delay(250);
  }

  // delay at the end of the full loop:
  delay(5000);
}

 