# Football Board App

This is an Android application that allows users to add players and a football (ball) to a football field (canvas). Players can be positioned randomly and labeled with editable names, while the ball is added only once at the center of the field without a name.

## Features
- Add players with predefined images and editable names.
- Ensure the football is added only once and does not have a label.
- Players can be positioned randomly on the field.

## Project Structure
```
FootballBoardApp/
│── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/orn/myapplication/
│   │   │   │   ├── MainActivity.java
│   │   │   │   ├── FootballBoardView.java
│   │   │   ├── res/
│   │   │   │   ├── drawable/
│   │   │   │   │   ├── player1.png
│   │   │   │   │   ├── player4.png
│   │   │   │   │   ├── football_ball.png
│   │   │   │   ├── layout/
│   │   │   │   │   ├── activity_main.xml
│   │   │   │   ├── values/
│   │   │   │   │   ├── strings.xml
```

## Setup Instructions
1. Clone the repository:
   ```sh
   git clone https://github.com/your-repository.git
   ```
2. Open the project in **Android Studio**.
3. Sync the Gradle files and ensure all dependencies are installed.
4. Run the project on an emulator or a physical device.

## Usage
- Click on **Add Player** buttons to add players at random positions.
- Click on the **Add Football** button to add the ball (only once).
- Tap on a player's name to edit it.

## Main Code Highlights
### **MainActivity.java**
- Handles UI interactions.
- Ensures only one football is added.
- Randomly positions players with default names.

### **FootballBoardView.java**
- Manages the drawing of players and the ball on the canvas.
- Allows dragging and renaming of players.

## Known Issues
- Ensure that player images are available in the **drawable** folder.
- If the football is not appearing, check the `isBallAdded` flag logic in `MainActivity.java`.

## Contributing
Feel free to contribute by submitting issues or pull requests.

## License
This project is licensed under the **MIT License**.

