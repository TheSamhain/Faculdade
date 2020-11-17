load mandrill;
colormap(gray(219));
%brighten(-0.9);
c = contrast(X);
colormap(c);
image(X);