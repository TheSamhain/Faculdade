numero = input('Insira um numero: ');
primos = 0;

for i = 0 : numero
    if i > 1
        for j = (i - 1) : 1
            if rem(i , j) == 0
                break;
            end
            if j == 2
                disp(i);
            end
        end
    else
        disp(i);
    end
end