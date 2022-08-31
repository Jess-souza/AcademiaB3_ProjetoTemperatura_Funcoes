import java.util.Scanner;

public class Main {
    private static double getTemp() {
        Scanner input = new Scanner(System.in);
        System.out.print("Digite o valor da temperatura: ");
        return input.nextDouble();
    }

    public static void main(String[] args) {
        double resultado;
        initialize();

        UnityTemp unityInput = getUnityTemp("entrada: ");
        UnityTemp unityOutput = getUnityTemp("saída: ");
        double temp = getTemp();

        System.out.println("Você vai transformar " + temp + " " + unityInput + " em " + unityOutput);

        switch (unityOutput) {
            case CELSIUS:
                resultado = toCelsiusTransform(unityInput, temp);
                break;

            case FAHRENHEIT:
                resultado = toFahrenheitTransform(unityInput, temp);
                break;

            case KELVIN:
                resultado = toKelvinTransform(unityInput, temp);
                break;

            default:
                resultado = 0;
                break;

        }

        System.out.printf("O resultado da conversão é %f", resultado);
    }

    private static UnityTemp getUnityTemp(String nomeQualquerDeVariavel) {
        Scanner input = new Scanner(System.in);
        System.out.print("Digite a unidade de temperatura de " + nomeQualquerDeVariavel);
        String typeString = input.nextLine();
        return UnityTemp.valueOf(typeString);
    }

    private static void initialize() {
        System.out.println("Bem vindo ao nosso conversor de temperaturas!");
    }

    public static double toFahrenheitTransform(UnityTemp type, double temp) {
        if (type == UnityTemp.CELSIUS) {
            return (temp * 1.8) + 32;
        } else if (type == UnityTemp.KELVIN) {
            return (temp * 1.8) - 459.67;
        } else {
            return temp;
        }
    }

    public static double toCelsiusTransform(UnityTemp type, double temp) {
        if (type == UnityTemp.FAHRENHEIT) {
            return (temp - 32) / 1.8;
        } else if (type == UnityTemp.KELVIN) {
            return temp - 273.15;
        } else {
            return temp;
        }
    }

    public static double toKelvinTransform(UnityTemp type, double temp) {
        switch (type) {
            case CELSIUS:
                return temp - 273.15;
            case FAHRENHEIT:
                return (temp * 1.8) - 459.67;
            default:
                return temp;
        }
    }

        /*if (type == UnityTemp.CELSIUS) {
            return temp - 273.15;
        } else if (type == UnityTemp.FAHRENHEIT) {
            return (temp * 1.8) - 459.67;
        } else {
            return temp;
        }*/
}
