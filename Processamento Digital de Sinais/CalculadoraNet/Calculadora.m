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

% Edit the above text to modify the response to help Calculadora

% Last Modified by GUIDE v2.5 18-Jan-2018 15:29:29

% Begin initialization code - DO NOT EDIT
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
% End initialization code - DO NOT EDIT


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


% --- Executes on button press in CALCULAR.
function CALCULAR_Callback(hObject, eventdata, handles)
% hObject    handle to CALCULAR (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)


% --- Executes on button press in numuno.
function numuno_Callback(hObject, eventdata, handles)
% hObject    handle to numuno (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)


% --- Executes on button press in numdos.
function numdos_Callback(hObject, eventdata, handles)
% hObject    handle to numdos (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Hint: get(hObject,'Value') returns toggle state of numdos


% --- Executes on button press in numtres.
function numtres_Callback(hObject, eventdata, handles)
% hObject    handle to numtres (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)


% --- Executes on button press in numcuatro.
function numcuatro_Callback(hObject, eventdata, handles)
% hObject    handle to numcuatro (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)


% --- Executes on button press in numcinco.
function numcinco_Callback(hObject, eventdata, handles)
% hObject    handle to numcinco (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)


% --- Executes on button press in numseis.
function numseis_Callback(hObject, eventdata, handles)
% hObject    handle to numseis (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)


% --- Executes on button press in numnueve.
function numnueve_Callback(hObject, eventdata, handles)
% hObject    handle to numnueve (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)


% --- Executes on button press in numocho.
function numocho_Callback(hObject, eventdata, handles)
% hObject    handle to numocho (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)


% --- Executes on button press in numsiete.
function numsiete_Callback(hObject, eventdata, handles)
% hObject    handle to numsiete (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)


% --- Executes on button press in numcero.
function numcero_Callback(hObject, eventdata, handles)
% hObject    handle to numcero (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)



function Pantalla_Callback(hObject, eventdata, handles)
% hObject    handle to edit2 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Hints: get(hObject,'String') returns contents of edit2 as text
%        str2double(get(hObject,'String')) returns contents of edit2 as a double


% --- Executes during object creation, after setting all properties.
function Pantalla_CreateFcn(hObject, eventdata, handles)
% hObject    handle to edit2 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    empty - handles not created until after all CreateFcns called

% Hint: edit controls usually have a white background on Windows.
%       See ISPC and COMPUTER.
if ispc && isequal(get(hObject,'BackgroundColor'), get(0,'defaultUicontrolBackgroundColor'))
    set(hObject,'BackgroundColor','white');
end


% --- Executes on button press in botonsuma.
function botonsuma_Callback(hObject, eventdata, handles)
% hObject    handle to botonsuma (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)


% --- Executes on button press in botondivision.
function botondivision_Callback(hObject, eventdata, handles)
% hObject    handle to botondivision (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)


% --- Executes on button press in botonporcentaje.
function botonporcentaje_Callback(hObject, eventdata, handles)
% hObject    handle to botonporcentaje (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)


% --- Executes on button press in botonresta.
function botonresta_Callback(hObject, eventdata, handles)
% hObject    handle to botonresta (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)


% --- Executes on button press in botonmultiplicacion.
function botonmultiplicacion_Callback(hObject, eventdata, handles)
% hObject    handle to botonmultiplicacion (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)


% --- Executes on button press in botonelevar.
function botonelevar_Callback(hObject, eventdata, handles)
% hObject    handle to botonelevar (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)


% --- Executes on button press in botonpunto.
function botonpunto_Callback(hObject, eventdata, handles)
% hObject    handle to botonpunto (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)


% --- Executes on button press in botonseno.
function botonseno_Callback(hObject, eventdata, handles)
% hObject    handle to botonseno (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)


% --- Executes on button press in botoncoseno.
function botoncoseno_Callback(hObject, eventdata, handles)
% hObject    handle to botoncoseno (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)


% --- Executes on button press in botontangente.
function botontangente_Callback(hObject, eventdata, handles)
% hObject    handle to botontangente (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)


% --- Executes on button press in botonarccose.
function botonarccose_Callback(hObject, eventdata, handles)
% hObject    handle to botonarccose (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)


% --- Executes on button press in botonarcseno.
function botonarcseno_Callback(hObject, eventdata, handles)
% hObject    handle to botonarcseno (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)


% --- Executes on button press in botonarctan.
function botonarctan_Callback(hObject, eventdata, handles)
% hObject    handle to botonarctan (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)


% --- Executes on button press in botonexponencialaequis.
function botonexponencialaequis_Callback(hObject, eventdata, handles)
% hObject    handle to botonexponencialaequis (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)


% --- Executes on button press in botonlogaritmo.
function botonlogaritmo_Callback(hObject, eventdata, handles)
% hObject    handle to botonlogaritmo (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)


% --- Executes on button press in botonln.
function botonln_Callback(hObject, eventdata, handles)
% hObject    handle to botonln (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)


% --- Executes on button press in botonRaiz.
function botonRaiz_Callback(hObject, eventdata, handles)
% hObject    handle to botonRaiz (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)


% --- Executes on button press in botonexponencial.
function botonexponencial_Callback(hObject, eventdata, handles)
% hObject    handle to botonexponencial (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)


% --- Executes on button press in grafica.
function grafica_Callback(hObject, eventdata, handles)
% hObject    handle to grafica (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Hint: get(hObject,'Value') returns toggle state of grafica


% --- Executes on selection change in popupmenu1.
function popupmenu1_Callback(hObject, eventdata, handles)
% hObject    handle to popupmenu1 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Hints: contents = cellstr(get(hObject,'String')) returns popupmenu1 contents as cell array
%        contents{get(hObject,'Value')} returns selected item from popupmenu1


% --- Executes during object creation, after setting all properties.
function popupmenu1_CreateFcn(hObject, eventdata, handles)
% hObject    handle to popupmenu1 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    empty - handles not created until after all CreateFcns called

% Hint: popupmenu controls usually have a white background on Windows.
%       See ISPC and COMPUTER.
if ispc && isequal(get(hObject,'BackgroundColor'), get(0,'defaultUicontrolBackgroundColor'))
    set(hObject,'BackgroundColor','white');
end


% --- Executes on button press in calcular.
function calcular_Callback(hObject, eventdata, handles)
% hObject    handle to calcular (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
calcular=get(handles.edit2,'string');
cal=eval(calcular);
set(handles.edit2,'string',cal);

% --- Executes on button press in uno.
function uno_Callback(hObject, eventdata, handles)
% hObject    handle to uno (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
texto=get(handles.edit2,'String');
texto=strcat(texto,'1');
valor=get(handles.edit3,'string');
set(handles.edit2,'String',texto);


% --- Executes on button press in dos.
function dos_Callback(hObject, eventdata, handles)
% hObject    handle to dos (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
texto=get(handles.edit2,'String');
texto=strcat(texto,'2');
set(handles.edit2,'String',texto);

% Hint: get(hObject,'Value') returns toggle state of dos


% --- Executes on button press in tres.
function tres_Callback(hObject, eventdata, handles)
% hObject    handle to tres (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
texto=get(handles.edit2,'String');
texto=strcat(texto,'3');
set(handles.edit2,'String',texto);


% --- Executes on button press in cuatro.
function cuatro_Callback(hObject, eventdata, handles)
% hObject    handle to cuatro (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
texto=get(handles.edit2,'String');
texto=strcat(texto,'4');
set(handles.edit2,'String',texto);


% --- Executes on button press in cinco.
function cinco_Callback(hObject, eventdata, handles)
% hObject    handle to cinco (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
texto=get(handles.edit2,'String');
texto=strcat(texto,'5');
set(handles.edit2,'String',texto);

% --- Executes on button press in seis.
function seis_Callback(hObject, eventdata, handles)
% hObject    handle to seis (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
texto=get(handles.edit2,'String');
texto=strcat(texto,'6');
set(handles.edit2,'String',texto);

% --- Executes on button press in nueve.
function nueve_Callback(hObject, eventdata, handles)
% hObject    handle to nueve (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
texto=get(handles.edit2,'String');
texto=strcat(texto,'9');
set(handles.edit2,'String',texto);

% --- Executes on button press in ocho.
function ocho_Callback(hObject, eventdata, handles)
% hObject    handle to ocho (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
texto=get(handles.edit2,'String');
texto=strcat(texto,'8');
set(handles.edit2,'String',texto);

% --- Executes on button press in siete.
function siete_Callback(hObject, eventdata, handles)
% hObject    handle to siete (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
texto=get(handles.edit2,'String');
texto=strcat(texto,'7');
set(handles.edit2,'String',texto);

% --- Executes on button press in cero.
function cero_Callback(hObject, eventdata, handles)
% hObject    handle to cero (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
texto=get(handles.edit2,'String');
texto=strcat(texto,'0');
set(handles.edit2,'String',texto);


function edit2_Callback(hObject, eventdata, handles)
% hObject    handle to edit2 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Hints: get(hObject,'String') returns contents of edit2 as text
%        str2double(get(hObject,'String')) returns contents of edit2 as a double


% --- Executes during object creation, after setting all properties.
function edit2_CreateFcn(hObject, eventdata, handles)
% hObject    handle to edit2 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    empty - handles not created until after all CreateFcns called

% Hint: edit controls usually have a white background on Windows.
%       See ISPC and COMPUTER.
if ispc && isequal(get(hObject,'BackgroundColor'), get(0,'defaultUicontrolBackgroundColor'))
    set(hObject,'BackgroundColor','white');
end


% --- Executes on button press in suma.
function suma_Callback(hObject, eventdata, handles)
% hObject    handle to suma (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
texto=get(handles.edit2,'String');
texto=strcat(texto,'+');
set(handles.edit2,'String',texto);

% --- Executes on button press in division.
function division_Callback(hObject, eventdata, handles)
% hObject    handle to division (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
texto=get(handles.edit2,'String');
texto=strcat(texto,'/');
set(handles.edit2,'String',texto);

% --- Executes on button press in porciento.
function porciento_Callback(hObject, eventdata, handles)
% hObject    handle to porciento (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
texto=get(handles.edit2,'String');
texto=strcat(texto,'%');
set(handles.edit2,'String',texto);

% --- Executes on button press in resta.
function resta_Callback(hObject, eventdata, handles)
% hObject    handle to resta (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
texto=get(handles.edit2,'String');
texto=strcat(texto,'-');
set(handles.edit2,'String',texto);

% --- Executes on button press in multiplicacion.
function multiplicacion_Callback(hObject, eventdata, handles)
% hObject    handle to multiplicacion (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
texto=get(handles.edit2,'String');
texto=strcat(texto,'*');
set(handles.edit2,'String',texto);

% --- Executes on button press in equisalan.
function equisalan_Callback(hObject, eventdata, handles)
% hObject    handle to equisalan (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
x=get(handles.edit2,'String');
x=strcat(x,'^(');
set(handles.edit2,'String',x);

% --- Executes on button press in punto.
function punto_Callback(hObject, eventdata, handles)
% hObject    handle to punto (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
texto=get(handles.edit2,'String');
texto=strcat(texto,'.');
set(handles.edit2,'String',texto);


% --- Executes on button press in sen.
function sen_Callback(hObject, eventdata, handles)
% hObject    handle to sen (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
seno=get(handles.edit2,'String');
valor=get(handles.Radianes,'Value');
if valor==1
    seno=strcat(seno,'sin(');
else
    seno=strcat(seno,'sind(');
end
set(handles.edit2,'String',seno);



% --- Executes on button press in cos.
function cos_Callback(hObject, eventdata, handles)
% hObject    handle to cos (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
coseno=get(handles.edit2,'String');
valor=get(handles.Radianes,'Value');
if valor==1
    coseno=strcat(coseno,'cos(');
else
    coseno=strcat(coseno,'cosd(');
end
set(handles.edit2,'String',coseno);



% --- Executes on button press in tan.
function tan_Callback(hObject, eventdata, handles)
% hObject    handle to tan (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
tangente=get(handles.edit2,'String');
valor=get(handles.Radianes,'Value');
if valor==1
    tangente=strcat(tangente,'tan(');
else
    tangente=strcat(tangente,'tand(');
end
set(handles.edit2,'String',tangente);


% --- Executes on button press in arccose.
function arccose_Callback(hObject, eventdata, handles)
% hObject    handle to arccose (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
arco=get(handles.edit2,'String');
arco=strcat(arco,'acosd(');
set(handles.edit2,'String',arco);


% --- Executes on button press in arcsen.
function arcsen_Callback(hObject, eventdata, handles)
% hObject    handle to arcsen (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
arseno=get(handles.edit2,'String');
arseno=strcat(arseno,'asind(');
set(handles.edit2,'String',arseno);


% --- Executes on button press in arctang.
function arctang_Callback(hObject, eventdata, handles)
% hObject    handle to arctang (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
artang=get(handles.edit2,'String');
artang=strcat(artang,'atand(');
set(handles.edit2,'String',artang);


% --- Executes on button press in equiscuadrada.
function equiscuadrada_Callback(hObject, eventdata, handles)
% hObject    handle to equiscuadrada (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
x2=get(handles.edit2,'String');
x2=strcat(x2,'^(2)');
set(handles.edit2,'String',x2);

% --- Executes on button press in log.
function log_Callback(hObject, eventdata, handles)
% hObject    handle to log (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
log10=get(handles.edit2,'String');
log10=strcat(log10,'log10(');
set(handles.edit2,'String',log10);

% --- Executes on button press in logaritmonatural.
function logaritmonatural_Callback(hObject, eventdata, handles)
% hObject    handle to logaritmonatural (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
log=get(handles.edit2,'String');
log=strcat(log,'log(');
set(handles.edit2,'String',log);

% --- Executes on button press in Raiz.
function Raiz_Callback(hObject, eventdata, handles)
% hObject    handle to Raiz (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
A=get(handles.edit2,'String');
raiz=strcat(A,'sqrt(');
set(handles.edit2,'String',raiz);

% --- Executes on button press in exponencial.
function exponencial_Callback(hObject, eventdata, handles)
% hObject    handle to exponencial (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
exp=get(handles.edit2,'String');
exp=strcat(exp,'exp(');
set(handles.edit2,'String',exp);

% --- Executes on button press in graficar.
function graficar_Callback(hObject, eventdata, handles)
% hObject    handle to graficar (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
axes(handles.axes5);
plot(cal)



% --- Executes on selection change in popupmenu2.
function popupmenu2_Callback(hObject, eventdata, handles)
% hObject    handle to popupmenu2 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Hints: contents = cellstr(get(hObject,'String')) returns popupmenu2 contents as cell array
%        contents{get(hObject,'Value')} returns selected item from popupmenu2


% --- Executes during object creation, after setting all properties.
function popupmenu2_CreateFcn(hObject, eventdata, handles)
% hObject    handle to popupmenu2 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    empty - handles not created until after all CreateFcns called

% Hint: popupmenu controls usually have a white background on Windows.
%       See ISPC and COMPUTER.
if ispc && isequal(get(hObject,'BackgroundColor'), get(0,'defaultUicontrolBackgroundColor'))
    set(hObject,'BackgroundColor','white');
end


% --------------------------------------------------------------------
function cambio_Callback(hObject, eventdata, handles)
% hObject    handle to cambio (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)


% --------------------------------------------------------------------
function Untitled_1_Callback(hObject, eventdata, handles)
% hObject    handle to Untitled_1 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)


% --------------------------------------------------------------------
function nomal_Callback(hObject, eventdata, handles)
% hObject    handle to nomal (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)


% --------------------------------------------------------------------
function cientfk_Callback(hObject, eventdata, handles)
% hObject    handle to cientfk (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)


% --- Executes on button press in borrar.
function borrar_Callback(hObject, eventdata, handles)
% hObject    handle to borrar (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
borrar=char('');
set(handles.edit2,'string',borrar);


% --- Executes on button press in atras.
function atras_Callback(hObject, eventdata, handles)
% hObject    handle to atras (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
F=get(handles.edit2,'string');
A=size(F);
A=A(2);
E='0';
for i=1:A-1
   E(i)=F(i);
end
set(handles.edit2,'string',E);


% --- Executes on button press in incparentecis.
function incparentecis_Callback(hObject, eventdata, handles)
% hObject    handle to incparentecis (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
texto=get(handles.edit2,'String');
texto=strcat(texto,'(');
set(handles.edit2,'String',texto);

% --- Executes on button press in finparentecis.
function finparentecis_Callback(hObject, eventdata, handles)
% hObject    handle to finparentecis (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
texto=get(handles.edit2,'String');
texto=strcat(texto,')');
set(handles.edit2,'String',texto);


% --- Executes during object creation, after setting all properties.
function axes5_CreateFcn(hObject, eventdata, handles)
% hObject    handle to axes5 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    empty - handles not created until after all CreateFcns called

% Hint: place code in OpeningFcn to populate axes5

% --- Executes on button press in factorial.
function factorial_Callback(hObject, eventdata, handles)
% hObject    handle to factorial (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
Factorial=get(handles.edit2,'String');
Factorial=strcat(Factorial,'factorial(');
set(handles.edit2,'String',Factorial);


% --- Executes on button press in Pi.
function Pi_Callback(hObject, eventdata, handles)
% hObject    handle to Pi (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
texto=get(handles.edit2,'String');
texto=strcat(texto,'pi');
set(handles.edit2,'String',texto);


% --- Executes on button press in Radianes.
function Radianes_Callback(hObject, eventdata, handles)
% hObject    handle to Radianes (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Hint: get(hObject,'Value') returns toggle state of Radianes


% --------------------------------------------------------------------
function Cientifica_Callback(hObject, eventdata, handles)
% hObject    handle to Cientifica (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)


% --------------------------------------------------------------------
function DEReINT_Callback(hObject, eventdata, handles)
% hObject    handle to DEReINT (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)


% --- Executes on button press in Graf.
function Graf_Callback(hObject, eventdata, handles)
set(handles.text5,'String','')
ecuacion=get(handles.edit2,'String');
if isempty(ecuacion)==1,
   set(handles.text5,'String','ERROR: No existe ninguna Formula')
   return;
end;
ini=get(handles.edit3,'String');
fin=get(handles.edit4,'String');
h=get(handles.edit5,'String');
if isempty(ini)==1 && isempty(fin)==1 && isempty(h)==1,
   ini=-10;
   fin=10;
   h=.01;
elseif isempty(ini)==0 && isempty(fin)==0 && isempty(h)==1,
   if isempty(str2num(ini))==1 || isempty(str2num(fin))==1,
      set(handles.text5,'String','ERROR: Valores de entrada incorrectos')
      return;
   else
      ini=str2double(ini);
      fin=str2double(fin);
   end;
   if fin<ini,
      set(handles.text5,'String','ERROR: El intervalo Final es menor que el Intervalo Inicial')
      return;
   end;
   h=(fin-ini)/1000;
elseif isempty(ini)==0 && isempty(fin)==0 && isempty(h)==0,
   if isempty(str2num(ini))==1 || isempty(str2num(fin))==1 || isempty(str2num(h))==1,
      set(handles.text5,'String','ERROR: Valores de entrada Incorrectos')
      return;
   else
      ini=str2double(ini);
      fin=str2double(fin);
      h=str2double(h);
   end;
   if fin<ini,
      set(handles.text5,'String','ERROR: El intervalo Final es menor que el Intervalo Inicial')
      return;
   end;
else
   set(handles.text5,'String','ERROR: No existen valores de entrada')
   return;
end;
set(handles.edit3,'String',num2str(ini))
set(handles.edit4,'String',num2str(fin))
set(handles.edit5,'String',num2str(h))
x=ini:h:fin;
formula=inline(ecuacion);
n=length(x);
y=[];
for i=1:n,
    y=[y formula(x(i))];
end;
axes(handles.axes7)
plot(x,y,'b')
grid on
xlabel('x')
ylabel('f(x)')
tabla(:,1)=x;
tabla(:,2)=y;
set(handles.uitable1,'Data',tabla);

% hObject    handle to Graf (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)


% --- Executes on button press in x.
function x_Callback(hObject, eventdata, handles)
texto=get(handles.edit2,'String');
texto=strcat(texto,'x');
set(handles.edit2,'String',texto);
% hObject    handle to x (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)


% --- Executes on button press in z.
function z_Callback(hObject, eventdata, handles)
texto=get(handles.edit2,'String');
texto=strcat(texto,'z');
set(handles.edit2,'String',texto);
% hObject    handle to z (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)


% --- Executes on button press in y.
function y_Callback(hObject, eventdata, handles)
texto=get(handles.edit2,'String');
texto=strcat(texto,'y');
set(handles.edit2,'String',texto);
% hObject    handle to y (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)


% --- Executes on button press in pushbutton79.
function pushbutton79_Callback(hObject, eventdata, handles)
% hObject    handle to pushbutton79 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
f=get(handles.edit2,'String');
valor=get(handles.dx,'Value');
valor2=get(handles.dy,'Value');
valor3=get(handles.dz,'Value');
if valor==1
    syms x
    f=int(f,x);
    set(handles.edit2,'String',char(f));
end
if valor2==1
   syms y
   f=int(f,y);
   set(handles.edit2,'String',char(f));
end
if valor3==1
  syms z
  f=int(f,z);
set(handles.edit2,'String',char(f));
end



% --- Executes on button press in derivar.
function derivar_Callback(hObject, eventdata, handles)
% hObject    handle to derivar (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)
f=get(handles.edit2,'String');
valor=get(handles.dx,'Value');
valor2=get(handles.dy,'Value');
valor3=get(handles.dz,'Value');
if valor==1
syms x
f=diff(f,x);
 set(handles.edit2,'String',char(f));
end
if valor2==1
syms y
    f=diff(f,y);
    set(handles.edit2,'String',char(f));
end

if valor3==1
syms z
 f=diff(f,z);
 set(handles.edit2,'String',char(f));
end
   


% --- Executes on button press in pushbutton82.
function pushbutton82_Callback(hObject, eventdata, handles)
texto=get(handles.edit2,'String');
texto=strcat(texto,']');
set(handles.edit2,'String',texto);
% hObject    handle to pushbutton82 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)


% --- Executes on button press in pushbutton83.
function pushbutton83_Callback(hObject, eventdata, handles)
texto=get(handles.edit2,'String');
texto=strcat(texto,'[');
set(handles.edit2,'String',texto);
% hObject    handle to pushbutton83 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)


% --------------------------------------------------------------------
function Matriz_Callback(hObject, eventdata, handles)
% hObject    handle to Matriz (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)



function edit3_Callback(hObject, eventdata, handles)
% hObject    handle to edit3 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Hints: get(hObject,'String') returns contents of edit3 as text
%        str2double(get(hObject,'String')) returns contents of edit3 as a double


% --- Executes during object creation, after setting all properties.
function edit3_CreateFcn(hObject, eventdata, handles)
% hObject    handle to edit3 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    empty - handles not created until after all CreateFcns called

% Hint: edit controls usually have a white background on Windows.
%       See ISPC and COMPUTER.
if ispc && isequal(get(hObject,'BackgroundColor'), get(0,'defaultUicontrolBackgroundColor'))
    set(hObject,'BackgroundColor','white');
end



function edit4_Callback(hObject, eventdata, handles)
% hObject    handle to edit4 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Hints: get(hObject,'String') returns contents of edit4 as text
%        str2double(get(hObject,'String')) returns contents of edit4 as a double


% --- Executes during object creation, after setting all properties.
function edit4_CreateFcn(hObject, eventdata, handles)
% hObject    handle to edit4 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    empty - handles not created until after all CreateFcns called

% Hint: edit controls usually have a white background on Windows.
%       See ISPC and COMPUTER.
if ispc && isequal(get(hObject,'BackgroundColor'), get(0,'defaultUicontrolBackgroundColor'))
    set(hObject,'BackgroundColor','white');
end



function edit5_Callback(hObject, eventdata, handles)
% hObject    handle to edit5 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Hints: get(hObject,'String') returns contents of edit5 as text
%        str2double(get(hObject,'String')) returns contents of edit5 as a double


% --- Executes during object creation, after setting all properties.
function edit5_CreateFcn(hObject, eventdata, handles)
% hObject    handle to edit5 (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    empty - handles not created until after all CreateFcns called

% Hint: edit controls usually have a white background on Windows.
%       See ISPC and COMPUTER.
if ispc && isequal(get(hObject,'BackgroundColor'), get(0,'defaultUicontrolBackgroundColor'))
    set(hObject,'BackgroundColor','white');
end


% --- Executes when entered data in editable cell(s) in uitable1.
function uitable1_CellEditCallback(hObject, eventdata, handles)
% hObject    handle to uitable1 (see GCBO)
% eventdata  structure with the following fields (see UITABLE)
%	Indices: row and column indices of the cell(s) edited
%	PreviousData: previous data for the cell(s) edited
%	EditData: string(s) entered by the user
%	NewData: EditData or its converted form set on the Data property. Empty if Data was not changed
%	Error: error string when failed to convert EditData to appropriate value for Data
% handles    structure with handles and user data (see GUIDATA)


% --- Executes when selected cell(s) is changed in uitable1.
function uitable1_CellSelectionCallback(hObject, eventdata, handles)
% hObject    handle to uitable1 (see GCBO)
% eventdata  structure with the following fields (see UITABLE)
%	Indices: row and column indices of the cell(s) currently selecteds
% handles    structure with handles and user data (see GUIDATA)


% --- Executes on key press with focus on edit2 and none of its controls.
function edit2_KeyPressFcn(hObject, eventdata, handles)
% hObject    handle to edit2 (see GCBO)
% eventdata  structure with the following fields (see UICONTROL)
%	Key: name of the key that was pressed, in lower case
%	Character: character interpretation of the key(s) that was pressed
%	Modifier: name(s) of the modifier key(s) (i.e., control, shift) pressed
% handles    structure with handles and user data (see GUIDATA)


% --- Executes on button press in dx.
function dx_Callback(hObject, eventdata, handles)
% hObject    handle to dx (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Hint: get(hObject,'Value') returns toggle state of dx


% --- Executes on button press in dy.
function dy_Callback(hObject, eventdata, handles)
% hObject    handle to dy (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Hint: get(hObject,'Value') returns toggle state of dy


% --- Executes on button press in dz.
function dz_Callback(hObject, eventdata, handles)
% hObject    handle to dz (see GCBO)
% eventdata  reserved - to be defined in a future version of MATLAB
% handles    structure with handles and user data (see GUIDATA)

% Hint: get(hObject,'Value') returns toggle state of dz
