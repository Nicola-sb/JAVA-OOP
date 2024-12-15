package p01_Database;

import javax.naming.OperationNotSupportedException;

public class DatabaseFirstTask {

    private Integer[] elements;
    private int elementsCount = 0;
    private int index;


    public DatabaseFirstTask(Integer... elements) throws OperationNotSupportedException {
        this.elementsCount = elements.length;//равно на броя на елементите,които имам в масива
        this.setElements(elements);//преминаваме през сетъра за можем да валидирмаме  Integer[]elements > 16 && <1
        this.index = elementsCount - 1;//индекса винаги искам да го сложа на края на моя масив (А последния елеменита ми се намира на броя на елементите -1)
    }

    public void add(Integer element) throws OperationNotSupportedException {
        if (element == null) {
            throw new OperationNotSupportedException();
        }

        this.elements[++index] = element;
        this.elementsCount++;
    }

    public void remove() throws OperationNotSupportedException {
		try {
			this.elements[index--] = null;
			this.elementsCount--;			
		} catch (ArrayIndexOutOfBoundsException ex) {
			throw new OperationNotSupportedException();
		}
    }

    public Integer[] getElements() {
        Integer[] buffer = new Integer[elementsCount];
        int bufferIndex = 0;

        for (Integer element : elements) {
            if (element != null) {
                buffer[bufferIndex++] = element;
            }
        }

        return buffer;
    }

    private void setElements(Integer... elements) throws OperationNotSupportedException {
        if (elements.length > 16 ||
                elements.length < 1) {
            throw new OperationNotSupportedException();
        }

        this.elements = new Integer[16];
        int bufferIndex = 0;

        for (Integer element : elements) {
            this.elements[bufferIndex++] = element;
        }

        this.index = elements.length - 1;
    }
}
