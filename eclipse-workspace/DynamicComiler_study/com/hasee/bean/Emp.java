// Decompiled by Jad v1.5.8e2. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://kpdus.tripod.com/jad.html
// Decompiler options: packimports(3) fieldsfirst ansi space 
// Source File Name:   Emp.java

package com.hasee.bean;

import java.io.PrintStream;

public class Emp
{

	private String name;
	private int age;
	private double salary;

	public Emp(String s, int i)
	{
		name = s;
		age = i;
	}

	public void setName(String s)
	{
		name = s;
	}

	public String getName()
	{
		return name;
	}

	public void setAge(int i)
	{
		age = i;
	}

	public int getAge()
	{
		return age;
	}

	public int add(int i, int j)
	{
		System.out.println("����ͨ���ֽ��봴����add����");
		return i + j;
	}

	public void setSalaty(double d)
	{
		salary = d;
	}

	public double getSalary()
	{
		return salary;
	}
}
