package creational;

interface Button {
    void render();
}

interface Checkbox {
    void render();
}

class WindowsButton implements Button {
    public void render() {
        System.out.println("Rendering Windows Button");
    }
}

class WindowsCheckbox implements Checkbox {
    public void render() {
        System.out.println("Rendering Windows Checkbox");
    }
}

class MacOSButton implements Button {
    public void render() {
        System.out.println("Rendering MacOS Button");
    }
}

class MacOSCheckbox implements Checkbox {
    public void render() {
        System.out.println("Rendering MacOS Checkbox");
    }
}

interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}

class WindowsFactory implements GUIFactory {
    public Button createButton() {
        return new WindowsButton();
    }

    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }
}

class MacOSFactory implements GUIFactory {
    public Button createButton() {
        return new MacOSButton();
    }

    public Checkbox createCheckbox() {
        return new MacOSCheckbox();
    }
}

public class AbstractFactory {
    public static void main(String[] args) {
        // Dynamically select factory based on OS
        GUIFactory factory;
        String os = "Windows"; // Change to "MacOS" to test MacOS UI

        if (os.equalsIgnoreCase("Windows")) {
            factory = new WindowsFactory();
        } else {
            factory = new MacOSFactory();
        }

        Button button = factory.createButton();
        Checkbox checkbox = factory.createCheckbox();

        button.render();
        checkbox.render();
    }
}
