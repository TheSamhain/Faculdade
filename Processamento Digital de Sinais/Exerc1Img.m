[Tree, mapColorTree] = imread('trees.tif');

myColorMap = [1 0 0; 
              0 1 0; 
              0 0 1; 
              1 1 0; 
              1 0 1; 
              0 1 1; 
              0.5 0.8 0.3;
              0.8 0.5 0.3;
              0.8 0.3 0.5;
              0.3 0.8 0.5;
              0.3 0.5 0.8;
              0.5 0.3 0.8;
              0 0 0];

%in = [1 2 7 6 3 4 5 ; 
%      7 2 3 5 4 6 1; 
%      1 7 3 5 2 4 6];

colormap(myColorMap);
image(Tree);