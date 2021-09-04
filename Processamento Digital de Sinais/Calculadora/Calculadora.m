function varargout = Calculadora(varargin)
% CALCULADORA MATLAB code for Calculadora.fig
%      CALCULADORA, by itself, creates a new CALCULADORA or raises the existing
%      singleton*.
%
%      H = CALCULADORA returns the handle to a new CALCULADORA or the handle to
%      the existing singleton*.
%
%      CALCULADORA('CALLBACK',hObject,eventData,handles,...) calls the local
%      function named CALLBACK in CALCULADORA.M with the given input arguments.
%
%      CALCULADORA('Property','Value',...) creates a new CALCULADORA or raises the
%      existing singleton*.  Starting from the left, property value pairs are
%      applied to the GUI before Calculadora_OpeningFcn gets called.  An
%      unrecognized property name or invalid value makes property application
%      stop.  All inputs are passed to Calculadora_OpeningFcn via varargin.
%
%      *See GUI Options on GUIDE's Tools menu.  Choose "GUI allows only one
%      instance to run (singleton)".
%
% See also: GUIDE, GUIDATA, GUIHANDLES

% txtresult the above text to modify the response to help Calculadora

% Last Modified by GUIDE v2.5 20-Jun-2020 18:06:25

% Begin initialization code - DO NOT TXTRESULT
gui_Singleton = 1;
gui_State = struct('gui_Name',       mfilename, ...
                   'gui_Singleton',  gui_Singleton, ...
                   'gui_OpeningFcn', @Calculadora_OpeningFcn, ...
                   'gui_OutputFcn',  @Calculadora_OutputFcn, ...
                   'gui_LayoutFcn',  [] , ...
                   'gui_Callback',   []);
if nargin && ischar(varargin{1})
    gui_State.gui_Callback = str2func(varargin{1});
end

if nargout
    [varargout{1:nargout}] = gui_mainfcn(gui_State, varargin{:});
else
    gui_mainfcn(gui_State, varargin{:});
end
% End initialization code - DO NOT TXTRESULT


% --- Executes just before Calculadora is made visible.
function Calculadora_OpeningFcn(hObject, eventdata, handles, varargin)
% This function has no output args, see OutputFcn.
% hObject    handle to figure
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
% varargin   command line arguments to Calculadora (see VARARGIN)

% Choose default command line output for Calculadora
handles.output = hObject;

% Update handles structure
guidata(hObject, handles);

% UIWAIT makes Calculadora wait for user response (see UIRESUME)
% uiwait(handles.figure1);


% --- Outputs from this function are returned to the command line.
function varargout = Calculadora_OutputFcn(hObject, eventdata, handles) 
% varargout  cell array for returning output args (see VARARGOUT);
% hObject    handle to figure
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Get default command line output from handles structure
varargout{1} = handles.output;

function edit_Callback(hObject, eventdata, handles)
% hObject    handle to txtResult (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Hints: get(hObject,'String') returns contents of txtResult as text
%        str2double(get(hObject,'String')) returns contents of txtResult as a double


% --- Executes during object creation, after setting all properties.
function edit_CreateFcn(hObject, eventdata, handles)
% hObject    handle to txtResult (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    empty - handles not created until after all CreateFcns called

% Hint: txtResult controls usually have a white background on Windows.
%       See ISPC and COMPUTER.
if ispc && isequal(get(hObject,'BackgroundColor'), get(0,'defaultUicontrolBackgroundColor'))
    set(hObject,'BackgroundColor','white');
end


% ---  FUNÇÕES CRIADAS POR MIM  :)  --- 

%procura um caracter em uma string
function [retorno] = findStr(caracter, palavra)
if (length(strfind(palavra, caracter)) > 0)
    retorno = true;
else
    retorno = false;
end

% verifica se display está vazio
function [retorno] = displayVazio(handles)
if get(handles.txtResult, 'String') == ""
    retorno = true;
else 
    retorno = false;
end

%insere um caracter na última posição do display
function inserirCaracter(handles, char)
display = get(handles.txtResult, 'String');

if (display ~= "") && (~findStr("Erro",display))
	ultimoCaracter = display(end); % pega o último caracter do display

    
    % verifica se caracter inserido é de operação
	if not (findStr(char, "0123456789 x () ^ sqrt . "))
        if (display == "") % se o display estiver vazio não insere a operação
            return;
        end
   
        % se o último caracter não for número, não insere nada
        if  ( not(findStr(ultimoCaracter, "0123456789 x () ^ sqrt . ")) ) 
            return;
        end 

    end

    if (char == "x") % verifica se o caracter inserido é 'x'
    	if (ultimoCaracter == "x") % se o último caracter dentro dela for "x", não insere nada
        	return;
        end
    end
end

% a partir daqui insere o caracter
display = display + char; % adiciona o caracter no display
set(handles.txtResult, 'String', display); % insere no display


% --- FIM - FUNÇÕES CRIADAS POR MIM  :(  ---


% --- Executes on button press in btn7.
function btn7_Callback(hObject, eventdata, handles)
% hObject    handle to btn7 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
inserirCaracter(handles, "7")

% --- Executes on button press in btn8.
function btn8_Callback(hObject, eventdata, handles)
% hObject    handle to btn8 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
inserirCaracter(handles, "8")

% --- Executes on button press in btn9.
function btn9_Callback(hObject, eventdata, handles)
% hObject    handle to btn9 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
inserirCaracter(handles, "9")

% --- Executes on button press in btn4.
function btn4_Callback(hObject, eventdata, handles)
% hObject    handle to btn4 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
inserirCaracter(handles, "4")

% --- Executes on button press in btn5.
function btn5_Callback(hObject, eventdata, handles)
% hObject    handle to btn5 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
inserirCaracter(handles, "5")

% --- Executes on button press in btn6.
function btn6_Callback(hObject, eventdata, handles)
% hObject    handle to btn6 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
inserirCaracter(handles, "6")

% --- Executes on button press in btn1.
function btn1_Callback(hObject, eventdata, handles)
% hObject    handle to btn1 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
inserirCaracter(handles, "1")

% --- Executes on button press in btn2.
function btn2_Callback(hObject, eventdata, handles)
% hObject    handle to btn2 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
inserirCaracter(handles, "2")

% --- Executes on button press in btn3.
function btn3_Callback(hObject, eventdata, handles)
% hObject    handle to btn3 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
inserirCaracter(handles, "3")

% --- Executes on button press in btn0.
function btn0_Callback(hObject, eventdata, handles)
% hObject    handle to btn0 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
inserirCaracter(handles, "0")

% --- Executes on button press in btnVirgula.
function btnVirgula_Callback(hObject, eventdata, handles)
% hObject    handle to btnVirgula (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
inserirCaracter(handles, ".");

% --- Executes on button press in btnSoma.
function btnSoma_Callback(hObject, eventdata, handles)
% hObject    handle to btnSoma (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
inserirCaracter(handles, "+");

% --- Executes on button press in btnSub.
function btnSub_Callback(hObject, eventdata, handles)
% hObject    handle to btnSub (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
inserirCaracter(handles, "-");

% --- Executes on button press in btnMult.
function btnMult_Callback(hObject, eventdata, handles)
% hObject    handle to btnMult (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
inserirCaracter(handles, "*");

% --- Executes on button press in btnDiv.
function btnDiv_Callback(hObject, eventdata, handles)
% hObject    handle to btnDiv (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
inserirCaracter(handles, "/");

% --- Executes on button press in btnX.
function btnX_Callback(hObject, eventdata, handles)
% hObject    handle to btnX (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
inserirCaracter(handles, "x");


% --- Executes on button press in btnElevar.
function btnElevar_Callback(hObject, eventdata, handles)
% hObject    handle to btnElevar (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
inserirCaracter(handles, "^");

% --- Executes on button press in btnRaiz.
function btnRaiz_Callback(hObject, eventdata, handles)
% hObject    handle to btnRaiz (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
inserirCaracter(handles, "sqrt(");

% --- Executes on button press in btnFact.
function btnFact_Callback(hObject, eventdata, handles)
% hObject    handle to btnFact (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
inserirCaracter(handles, "factorial(");

% --- Executes on button press in btnLog.
function btnLog_Callback(hObject, eventdata, handles)
% hObject    handle to btnLog (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
inserirCaracter(handles, "log(");

% --- Executes on button press in btnAParent.
function btnAParent_Callback(hObject, eventdata, handles)
% hObject    handle to btnAParent (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
inserirCaracter(handles, "(");

% --- Executes on button press in btnFParent.
function btnFParent_Callback(hObject, eventdata, handles)
% hObject    handle to btnFParent (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
inserirCaracter(handles, ")");

% --- Executes on button press in btnIgual.
function btnIgual_Callback(hObject, eventdata, handles)
% hObject    handle to btnIgual (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
expressao = get(handles.txtResult, 'String');

if (~displayVazio(handles))
    try
        resultado = eval(expressao);
        set(handles.txtResult, 'String', resultado);
    catch 
        set(handles.txtResult, 'String',  "Erro");
    end
end


% --- Executes on button press in btnClear.
function btnClear_Callback(hObject, eventdata, handles)
% hObject    handle to btnClear (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
set(handles.txtResult, 'String', "");
set(handles.txtResult, 'String', "");


% --- Executes on button press in btnDeriv.
function btnDeriv_Callback(hObject, eventdata, handles)
% hObject    handle to btnDeriv (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
display = get(handles.txtResult, 'String');

try
    f = sym(str2func(['@(x)',display]));
    display = diff(f);
    set(handles.txtResult, 'String',  char(display)); 
catch
    set(handles.txtResult, 'String',  "Erro");    
end



% --- Executes on button press in btnIntegral.
function btnIntegral_Callback(hObject, eventdata, handles)
% hObject    handle to btnIntegral (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
display = get(handles.txtResult, 'String');

try
    f = sym(str2func(['@(x)',display]));
    display = int(f);
    set(handles.txtResult, 'String',  char(display)); 
catch
    set(handles.txtResult, 'String',  "Erro");    
end


% --- Executes on button press in btnGraf.
function btnGraf_Callback(hObject, eventdata, handles)
% hObject    handle to btnGraf (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
display = get(handles.txtResult, 'String');

if ( isempty(display)==1)
   set(handles.txtResult, 'String', 'ERRO: Não existe nenhuma Fórmula');
   return;
end;

ini = -10;
fin = 10;
h   = .01;

x = ini:h:fin;
formula = inline(display);
n = length(x);
y = [];

for i = 1:n,
    y = [y formula(x(i))];
end;

axes(handles.axes1)
plot(x,y,'b')
grid on
xlabel('x')
ylabel('f(x)')

function txtResult_Callback(hObject, eventdata, handles)
% hObject    handle to txtResult (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Hints: get(hObject,'String') returns contents of txtResult as text
%        str2double(get(hObject,'String')) returns contents of txtResult as a double


% --- Executes during object creation, after setting all properties.
function txtResult_CreateFcn(hObject, eventdata, handles)
% hObject    handle to txtResult (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    empty - handles not created until after all CreateFcns called

% Hint: txtResult controls usually have a white background on Windows.
%       See ISPC and COMPUTER.
if ispc && isequal(get(hObject,'BackgroundColor'), get(0,'defaultUicontrolBackgroundColor'))
    set(hObject,'BackgroundColor','white');
end


% --- Executes on button press in btnPorc.
function btnPorc_Callback(hObject, eventdata, handles)
% hObject    handle to btnPorc (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
