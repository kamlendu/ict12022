/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package transformapp;
/**
 * @author Kamlendu Pandey
 * 
 * This program demonstrates 2 D transformation of a geometrical shape. 
 * Only translation, scaling and rotation are covered
 */
public class TransformApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
      // The coordinates of shape to be transformed
        double[][] shape = {{2, 4, 3, 5}, {3, 5, 6, 2}, {1, 1, 1, 1}};
        //{{x1,x2,x3,x4},{y1,y2,y3,y4},{1,1,1,1}};
       // Translation matrix
        double[][] tr = {{1, 0, 5}, {0, 1, 2}, {0, 0, 1}};  // Tx = 5 and ty =3
        // Scaling matrix
        double[][] sc = {{3, 0, 0}, {0, 4, 0}, {0, 0, 1}}; // sx=3 and sy=4
       // TODO code application logic here
        double degrees = 45.0; // Angle of rotation from origin
        double radians = Math.toRadians(degrees);
        double sint = Math.sin(radians);
        double cost = Math.cos(radians);
        // Rotation matrix
        double[][] rot = {{cost, -sint, 0}, {sint, cost, 0}, {0, 0, 1}};

        shape = mulMatrix(shape, tr); // translate
        shape = mulMatrix(shape, sc); // scale 
        shape = mulMatrix(shape, rot);  // rotate

        System.out.println(shape[0].length);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.println(shape[i][j]);
            }
        }
    }

    
    static double[][] mulMatrix(double s[][], double p[][]) {

        int noOfVertex = s[0].length;
        double[][] result = new double[3][4];

        for (int i = 0; i < noOfVertex; i++) {
            for (int j = 0; j < 3; j++) {
                result[j][i] = 0;
                for (int k = 0; k < 3; k++) {
                    result[j][i] += s[k][i] * p[j][k];
                }//end of k loop  

            }//end of j loop  

        }

        return result;
    }

}
