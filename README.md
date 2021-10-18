# GuiAPI
GUI Api for bukkit plugins, with 1.16 to 1.17 support.

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
                        <pattern>com.github.vicen621.guiapi</pattern>
                        <!-- Replace 'com.yourpackage' with the package of your plugin ! -->
                        <shadedPattern>com.yourpackage.guiapi</shadedPattern>
                    </relocation>
                </relocations>
            </configuration>
        </plugin>
    </plugins>
</build>

<dependencies>
    <dependency>
        <groupId>com.github.vicen621</groupId>
        <artifactId>GuiApi</artifactId>
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
}

dependencies {
    implementation 'com.github.vicen621:GuiApi:1.0-SNAPSHOT'
}

shadowJar {
    // Replace 'com.yourpackage' with the package of your plugin 
    relocate 'com.github.vicen621.guiapi', 'com.yourpackage.guiapi'
}
```

## Usage

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


