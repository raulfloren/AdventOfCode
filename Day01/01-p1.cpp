#include <iostream>
#include <fstream>

using namespace std;

enum Rotation
{
    LEFT = 'L',
    RIGHT = 'R'
};

int main(int argc, char *argv[])
{
    if (argc < 2)
    {
        cerr << "Usage: " << argv[0] << " <input>" << endl;
        return 1;
    }

    ifstream file(argv[1]);

    if (!file.is_open())
    {
        cerr << "Error: Could not open file " << argv[1] << endl;
        return 1;
    }

    int dial = 50;
    int zeroCount = 0;

    char rotation;
    int distance;

    while (file >> rotation >> distance)
    {
        if (rotation == LEFT)
        {
            dial -= distance;
            dial %= 100;

            if (dial < 0)
                dial += 100;
        }
        else if (rotation == RIGHT)
        {
            dial += distance;
            dial %= 100;
        }

        if (dial == 0)
            zeroCount++;
    }

    file.close();

    cout << "Number of zeros: " << zeroCount << endl;

    return 0;
}