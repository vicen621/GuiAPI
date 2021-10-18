# GuiAPI
Lightweight and easy-to-use GUI API for Bukkit plugins.

## Instalation

### Maven
```xml
<build>
    <plugins>
        <plugin>
            <groupId>org.apache.maven.plugins</groupId>
            <artifactId>maven-shade-plugin</artifactId>
            <version>3.2.4</version>
            <executions>
                <execution>
                    <phase>package</phase>
                    <goals>
                        <goal>shade</goal>
                    </goals>
                </execution>
            </executions>
            <configuration>
                <relocations>
                    <relocation>
                        <pattern>io.github.vicen621.guiapi</pattern>
                        <!-- Replace 'com.yourpackage' with the package of your plugin ! -->
                        <shadedPattern>com.yourpackage.guiapi</shadedPattern>
                    </relocation>
                </relocations>
            </configuration>
        </plugin>
    </plugins>
</build>

<repositories>
    <repository>
        <id>snapshot</id>
        <url>https://s01.oss.sonatype.org/content/repositories/snapshots</url>
    </repository>
</repositories>

<dependencies>
    <dependency>
        <groupId>io.github.vicen621</groupId>
        <artifactId>gui-api</artifactId>
        <version>1.0-SNAPSHOT</version>
    </dependency>
</dependencies>
```

### Gradle

```groovy
plugins {
    id 'com.github.johnrengelman.shadow' version '6.1.0'
}

repositories {
    mavenCentral()
    maven { url 'https://s01.oss.sonatype.org/content/repositories/snapshots' }
}

dependencies {
    implementation 'io.github.vicen621:gui-api:1.0-SNAPSHOT'
}

shadowJar {
    // Replace 'com.yourpackage' with the package of your plugin 
    relocate 'io.github.vicen621.guiapi', 'com.yourpackage.guiapi'
}
```

## Usage

### Hook

```java
// In your onEnable you have to put the following line to hook the API
@Override
public void onEnable() {
    new GUIManager(this);
}
```

### Creating a GUI

```java
// Create the inventory with the id, name and number of rows
InventoryGUI gui = new InventoryGUI("test_gui", "Test", 3);
// Add a button to de GUI
gui.setButton("test_btn", 13, new ItemStack(Material.BARRIER));
// Fill the inventory with white glass pane
gui.fill(new ItemStack(Material.WHITE_STAINED_GLASS_PANE));
// And open the inventory to the player
gui.open(player);
```

### Listening to buttons

```java
@EventHandler
public void onButtonClick(InventoryButtonClickEvent e) {
    if (e.getInventoryGUI().getID().eqalsIgnoreCase("test")) {
        plugin.getLogger().info(e.getButtonID());
    }
}
```

## JavaDocs

You can found the javadocs at https://vicen621.github.io/GuiAPI

## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update tests as appropriate.

## License
[MIT](https://choosealicense.com/licenses/mit/)
