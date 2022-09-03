import java.util.Scanner;

public class Main {
    private static double getTemp() {
        Scanner input = new Scanner(System.in);
        System.out.print("Digite o valor da temperatura: ");
        return input.nextDouble();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int quantidade;
        double[] temperaturas;
        double media = 0;
        double resultado;
        initialize();

        System.out.print("Digite a quantidade de temperatura(s) para conversão: ");
        quantidade = input.nextInt();

        temperaturas = new double[quantidade];

        for (int i = 0; i < quantidade; i++) {
            System.out.println("Digite o valor da temperatura: " + i);
            temperaturas[i] = input.nextDouble();
        }

        UnityTemp unityInput = getUnityTemp("entrada: ");
        UnityTemp unityOutput = getUnityTemp("saída: ");

        for (double temp : temperaturas) {

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
            return ((temp -32)* 1.8) + 273.15;
        } else {
            return temp;
        }
    }

    public static double toCelsiusTransform(UnityTemp type, double temp) {
        if (type == UnityTemp.FAHRENHEIT) {
            return (temp - 32) / 1.8;
        } else if (type == UnityTemp.KELVIN) {
            return temp + 273.15;
        } else {
            return temp;
        }
    }

    public static double toKelvinTransform(UnityTemp type, double temp) {
        switch (type) {
            case CELSIUS:
                return temp - 273.15;
            case FAHRENHEIT:
                return ((temp - 273.15) * 1.8 )+ 32;
            default:
                return temp;
        }
    }
}
