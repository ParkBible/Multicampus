class A {}
class B {}

class D extends A {}
class E extends D {}  // �븦 ���İ��� ��ӹ޴� ���� ���߻���� �ƴϴ�. (A->D->E)

interface IA {}
interface IB {}

// �������̽� ����ؼ� �������̽� ����� ���߻�� ����
interface IC extends IA, IB {}

// �������̽� ����ؼ� Ŭ���� ����ÿ��� ���߻�� ����!
class F implements IA, IB{}
class G extends B implements IA, IB {}

public class Test107{
	public static void main(String[] args){
	}
}

/*
	�������̽��� ���߻���� �����Ѵ�.
	class C extends A, B {} : 2�� �̻��� Ŭ�����κ��� ���ÿ� ��ӹ޴� ��.
	java���� �̰��� ������ �ʴ´�.
	���� �ٸ� �ڼտ��� �ٸ��� �������̵��� �ؼ� �� �����Ͱ� �� ���� ����Ű�� �Ǵ� ���� �ȵǴ� ��Ȳ, '���̾Ƹ�� ����'��
	�߻���Ű�� �ʵ��� �����Ѵ�. C++�� ���̴� ������ �̷� ������ �߻�ġ �ʴ� �� ������ ���Ѵ�. �ڹٴ� ��.
*/