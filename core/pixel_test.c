#include <stdio.h>

int main() {
    int width = 100;  
    int height = 100; 

    int dot_x = 50;
    int dot_y = 50;

    int dot_r = 255;
    int dot_g = 0;
    int dot_b = 0;

    FILE *f = fopen("image.ppm", "w");

    fprintf(f, "P3\n");
    fprintf(f, "%d %d\n", width, height); 
    fprintf(f, "255\n");                    

    for (int y = 0; y < height; y++) {
        for (int x = 0; x < width; x++) {
            if (x == dot_x && y == dot_y) {
                fprintf(f, "%d %d %d ", dot_r, dot_g, dot_b);
            } else {
                fprintf(f, "255 255 255 ");
            }
        }
        fprintf(f, "\n");
    }

    fclose(f);

    printf("Dot drawn at (%d, %d) in image.ppm\n", dot_x, dot_y);

    return 0;
}
